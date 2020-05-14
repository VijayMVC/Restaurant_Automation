﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TESTRESTRO.Provider
{
    public class ErrorCode
    {
        public static string InternalServerError = "500";
        public static ErrorModel BadRequest = new ErrorModel { ErrorCode = "400", ErrorMessage = "Bad Request" };
    }
}