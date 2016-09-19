using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator.App_Code
{
    class Chenshan : Clothes
    {
        public Chenshan(IAffair obj) : base(obj)
        {

        }
        public override void Operation()
        {
            base.Operation();
            Console.Write("衬衫 ");
        }
    }
}
