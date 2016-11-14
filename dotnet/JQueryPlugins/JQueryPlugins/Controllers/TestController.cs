using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JQueryPlugins.Controllers
{
    public class TestController : Controller
    {
        // GET: Test
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Test1()
        {
            return View();
        }

        [HttpPost]
        public JsonResult Test2()
        {
            var name = Request["name"];
            var age = Convert.ToInt32(Request["age"]);
            return Json(new { name, age });
        }

    }
}