﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Web;
using System.Web.Mvc;

namespace EFExample.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            var a = Assembly.Load("Sunxsh.Test.Lib");
            var b = a.CreateInstance("Sunxsh.Test.Lib.MyClass");
            

            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}