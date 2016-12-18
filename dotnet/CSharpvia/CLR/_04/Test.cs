using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04
{
    public class Test
    {
        public int Age { get; set; }

        public static Test operator +(Test t1, Test t2)
        {
            t1.Age = t1.Age + t2.Age;
            return t1;
        }

        public static implicit operator Int32(Test t)
        {
            return t.Age;
        }

    }
}
