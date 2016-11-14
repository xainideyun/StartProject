using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator.App_Code
{
    class Person : IAffair
    {
        private string _name;
        public Person(string name)
        {
            this._name = name;
        }
        public void Operation()
        {
            Console.Write(_name + " ");
        }
    }
}
