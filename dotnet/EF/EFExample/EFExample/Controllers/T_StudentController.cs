using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using EFLib;

namespace EFExample.Controllers
{
    public class T_StudentController : Controller
    {
        private H3Entities db = new H3Entities();

        // GET: T_Student
        public ActionResult Index()
        {
            return View(db.T_Student.ToList());
        }

        // GET: T_Student/Details/5
        public ActionResult Details(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            T_Student t_Student = db.T_Student.Find(id);
            if (t_Student == null)
            {
                return HttpNotFound();
            }
            return View(t_Student);
        }

        // GET: T_Student/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: T_Student/Create
        // 为了防止“过多发布”攻击，请启用要绑定到的特定属性，有关 
        // 详细信息，请参阅 http://go.microsoft.com/fwlink/?LinkId=317598。
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,Name,Age,UserName")] T_Student t_Student)
        {
            if (ModelState.IsValid)
            {
                db.T_Student.Add(t_Student);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(t_Student);
        }

        // GET: T_Student/Edit/5
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            T_Student t_Student = db.T_Student.Find(id);
            if (t_Student == null)
            {
                return HttpNotFound();
            }
            return View(t_Student);
        }

        // POST: T_Student/Edit/5
        // 为了防止“过多发布”攻击，请启用要绑定到的特定属性，有关 
        // 详细信息，请参阅 http://go.microsoft.com/fwlink/?LinkId=317598。
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,Name,Age,UserName")] T_Student t_Student)
        {
            if (ModelState.IsValid)
            {
                db.Entry(t_Student).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(t_Student);
        }

        // GET: T_Student/Delete/5
        public ActionResult Delete(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            T_Student t_Student = db.T_Student.Find(id);
            if (t_Student == null)
            {
                return HttpNotFound();
            }
            return View(t_Student);
        }

        // POST: T_Student/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            T_Student t_Student = db.T_Student.Find(id);
            db.T_Student.Remove(t_Student);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
