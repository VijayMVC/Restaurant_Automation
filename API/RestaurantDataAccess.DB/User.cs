//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace RestaurantDataAccess.DB
{
    using System;
    using System.Collections.Generic;
    
    public partial class User
    {
        public User()
        {
            this.Carts = new HashSet<Cart>();
            this.MenuItems = new HashSet<MenuItem>();
            this.MenuItems1 = new HashSet<MenuItem>();
            this.MenuItems2 = new HashSet<MenuItem>();
            this.Reservations = new HashSet<Reservation>();
        }
    
        public int userId { get; set; }
        public string FirstName { get; set; }
        public string lastName { get; set; }
        public string gender { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public string phoneNo { get; set; }
        public string profileImage { get; set; }
        public System.DateTime createdDate { get; set; }
        public Nullable<System.DateTime> updatedDate { get; set; }
        public Nullable<System.DateTime> deletedDate { get; set; }
        public Nullable<int> userTypeId { get; set; }
    
        public virtual ICollection<Cart> Carts { get; set; }
        public virtual ICollection<MenuItem> MenuItems { get; set; }
        public virtual ICollection<MenuItem> MenuItems1 { get; set; }
        public virtual ICollection<MenuItem> MenuItems2 { get; set; }
        public virtual ICollection<Reservation> Reservations { get; set; }
        public virtual token token { get; set; }
        public virtual UserType UserType { get; set; }
    }
}
