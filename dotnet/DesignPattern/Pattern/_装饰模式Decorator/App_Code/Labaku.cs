using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator.App_Code
{
    class Labaku : Clothes
    {
        public Labaku(IAffair obj) : base(obj)
        {

        }
        public override void Operation()
        {
            base.Operation();
            Console.Write("喇叭裤 ");
        }
    }
}
