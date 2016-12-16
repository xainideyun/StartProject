using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06Practise
{
    class DiyTuple
    {
        public static Tuple<int, int> MinMax(int a, int b)
        {
            return new Tuple<int, int>(Math.Min(a, b), Math.Max(a, b));
        }
    }
}
