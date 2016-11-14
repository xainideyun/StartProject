using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FileUpload.Controllers
{
    public class TestController : Controller
    {
        // GET: Test
        public ActionResult Index()
        {
            return View();
        }

        public JsonResult Test1()
        {

            return Json(new { name = Request.Params["name"], age = Request["age"], number = Request["number"] });
        }

    }
}