﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RESTRODBACCESS.RequestModel
{
    public class UserRegisterRequestModel
    {
        public string Email { get; set; }
        public string Password { get; set; }
        public string FirstName { get; set; }
        public string lastName{ get; set; }
        public int UserType { get; set; }
        public string Phone { get; set; }

    }
}
