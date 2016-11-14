using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03
{
    public class Test1
    {
        public Test1()
        {
            _name = "孙小双";
        }
        private readonly string _name;

        private volatile int _age;

        public static readonly int MaxEntriesInList = 50; 
    }
}
