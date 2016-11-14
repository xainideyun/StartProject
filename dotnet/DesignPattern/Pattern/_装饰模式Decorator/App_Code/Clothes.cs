using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _装饰模式Decorator.App_Code
{
    public abstract class Clothes : IAffair
    {
        protected IAffair clothes;

        public Clothes(IAffair obj)
        {
            clothes = obj;
        }
        
        public virtual void Operation()
        {
            if (clothes != null)
                clothes.Operation();
        }
    }
}
