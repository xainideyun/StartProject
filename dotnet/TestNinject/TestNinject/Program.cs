using Ninject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    class Program
    {
        static void Main(string[] args)
        {
            var kerner = new StandardKernel();
            kerner.Bind<IDataBase>().To<SqlServer>();
            kerner.Bind<IShowData>().To<ShowData>();
            kerner.Bind<DBManager>().ToSelf();
            var db = kerner.Get<DBManager>();
            db.Show();
            Console.ReadKey();
        }
    }
}
