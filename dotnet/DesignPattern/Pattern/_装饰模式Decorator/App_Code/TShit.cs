using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator.App_Code
{
    class TShit : Clothes
    {
        public TShit(IAffair obj) : base(obj)
        {

        }

        public override void Operation()
        {
            base.Operation();
            Console.Write("T恤 ");
        }

    }
}
