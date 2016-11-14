using JQueryPlugins.App_Start;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace JQueryPlugins.Controllers
{
    public class TableController : Controller
    {
        // GET: Table
        public ActionResult Index()
        {

            return View();
        }

        public JsonResult Get()
        {
            string sort = Request["sort"];
            string sortExpression = Request["sortExpression"];
            int pageIndex = Convert.ToInt32(Request["pageIndex"]);
            int pageSize = Convert.ToInt32(Request["pageSize"]);

            var count = (int)SqlHelper.ExcuteScalar("select count(*) from T_Student");

            var result = SqlHelper.ExcuteTable(string.Format("select * from (select Row_Number() Over(Order By {0} {1}) R_Index, ID, Name, Age, UserName from t_student)t where R_Index Between @PageStart And @PageEnd", sortExpression, sort), a => new { Name = a["Name"].ToString(), Age = (int)a["Age"], UserName = a["UserName"].ToString() }, new SqlParameter("@PageStart", (pageIndex - 1) * pageSize + 1), new SqlParameter("@PageEnd", pageIndex * pageSize));
            return Json(new { total = count, rows = result }, JsonRequestBehavior.AllowGet);
        }

        unsafe class Student
        {

        }

}
}