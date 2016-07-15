using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    public class SqlServer : IDataBase
    {
        public void Add()
        {
            Console.WriteLine("SqlServer 添加函数...");
        }

        public void Delete()
        {
            Console.WriteLine("SqlServer 删除函数...");
        }

        public void Select()
        {
            Console.WriteLine("SqlServer 查找函数...");
        }

        public void Show()
        {
            Console.WriteLine(this.GetType().FullName);
        }

        public void Update()
        {
            Console.WriteLine("SqlServer 修改函数...");
        }
    }
}
