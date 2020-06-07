USE [restomation]
GO
/****** Object:  StoredProcedure [dbo].[deleteorModifyCartItems]    Script Date: 06-06-2020 21:43:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 -- select * from cart
--exec deleteorModifyCartItems 1 ,2,0
ALTER PROCEDURE [dbo].[deleteorModifyCartItems]
(
	 @isDelete bit,
	--@userId	int,
	@cartId int,
	@quantity int
)
AS
BEGIN
	
	SET NOCOUNT ON;

	BEGIN -- Variables

		DECLARE @_isdelete		bit = @isDelete	
		--DECLARE @_userId	int	 = @userId	
		DECLARE @_cartId	int	 = @cartId
		DECLARE @_quantity	int	 = @quantity	

		DECLARE @_total numeric(10,2) = null
		--DECLARE @_deleted_date datetime = NULL
		--DECLARE @_currentTime	datetime = GETDATE()
	END

	/*if(@quantity=0)
	begin
		set @_quantity = null;
	end*/

	BEGIN 
		
		--SELECT * FROM cart WHERE cartId=@_cartId
		

		IF @_isdelete=0
			BEGIN
				UPDATE Cart 
				SET quantity = @_quantity
				where cartId=@_cartId

				SELECT @_total=sum(cart.quantity*menuitems.price) 
				FROM Cart JOIN MenuItems 
				On 
				Cart.menuItemId=menuItems.itemId
				WHERE addedBy = (select addedBy from Cart where cartId = @_cartId)
				GROUP BY addedBy

			if(@@ROWCOUNT > 0)
			begin
				Select '1' as 'StatusCode', 'Quantity updated' as 'StatusMessage', @_total as 'Total', @_quantity as 'Quantity';
			end
			else
			begin
				Select '0' as 'StatusCode', 'Failed to update' as 'StatusMessage', @_total as 'Total', null as 'Quantity';
			end

				/*SELECT 
					
				Cart.cartId as 'cartId'
				,Cart.quantity as 'quantity'
				,(MenuItems.price*Cart.quantity ) as 'price'
						
				FROM Cart JOIN MenuItems
				ON Cart.menuItemId=MenuItems.itemId
				WHERE cartId = @_cartId*/
			END

		ELSE IF @_isdelete=1
			BEGIN
				DELETE FROM Cart
				where 
				cartId=@_cartId

				Declare  @isSuccess int = @@ROWCOUNT

				SELECT @_total=sum(cart.quantity*menuitems.price) 
				FROM Cart JOIN MenuItems 
				On 
				Cart.menuItemId=menuItems.itemId
				WHERE addedBy = (select addedBy from Cart where cartId = @_cartId)
				GROUP BY addedBy

			if(@isSuccess > 0)
			begin
			
				Select '1' as 'StatusCode', 'Deleted from Cart' as 'StatusMessage', @_total as 'Total', null as 'Quantity';
			end
			else
			begin
				Select '0' as 'StatusCode', 'Failed to delete from Cart' as 'StatusMessage', @_total as 'Total', null as 'Quantity';
			end

				/*SELECT cartId from
				Cart 
				where addedBy=@_userId*/



			END
			
			 
			
		ELSE
		BEGIN
			SELECT '003' AS 'ErrorCode', 'Couldnt delete' AS 'ErrorMessage'
		END

	END

END
