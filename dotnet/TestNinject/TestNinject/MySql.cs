using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    public class MySql : IDataBase
    {
        public void Add()
        {
            Console.WriteLine("MySql 添加函数...");
        }

        public void Delete()
        {
            Console.WriteLine("MySql 删除函数...");
        }

        public void Select()
        {
            Console.WriteLine("MySql 查找函数...");
        }

        public void Show()
        {
            Console.WriteLine(this.GetType().FullName);
        }

        public void Update()
        {
            Console.WriteLine("MySql 修改函数...");
        }
    }
}
