using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06Practise
{
    public class CalcClass
    {
        public int Number1 { get; set; }
        public string Description { get; set; }
        public static CalcClass operator +(CalcClass c1, CalcClass c2)
        {
            c1.Number1 += c2.Number1;
            return c1;
        }


        public static implicit operator int(CalcClass cc)
        {
            return cc.Number1;
        }
        public static explicit operator string(CalcClass cc)
        {
            return cc.Description;
        }

    }
}
