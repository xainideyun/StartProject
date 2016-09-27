using FileUpload.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FileUpload.Controllers
{
    public class FileController : Controller
    {
        // GET: File
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Page1 ()
        {
            return View();
        }

        public ActionResult Page2()
        {
            return View();
        }

        public ActionResult Page3()
        {
            return View(new User());
        }

        [HttpPost]
        public JsonResult Upload()
        {
            var file = Request.Files;
            if (file!= null && file.Count > 0)
            {
                var f = file[0].FileName;
                return Json(new { name = f });
            }
            return Json(new { });
        }

        public JsonResult FormData()
        {
            var username = Request["username"];
            var accountnum = Request["accountnum"];
            var userfile = Request["userfile"];
            var oBlob = Request["webmasterfile"];
            return null;
        }




    }
}