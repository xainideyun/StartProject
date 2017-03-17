using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11接口
{
    public class MyCompare : IComparable
    {
        public int a;
        public MyCompare(int b)
        {
            a = b;
        }

        public int CompareTo(MyCompare other)
        {
            return a - other.a;
        }


        int IComparable.CompareTo(object obj)
        {
            return a - ((MyCompare)obj).a;
        }
    }
}
