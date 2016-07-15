using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    public class DBManager
    {
        private IDataBase _db;
        private IShowData _show;
        public DBManager(IDataBase db, IShowData show)
        {
            _db = db;
            _show = show;
        }
        public void Show()
        {
            _db.Show();
            _show.Show();
        }
    }
}
