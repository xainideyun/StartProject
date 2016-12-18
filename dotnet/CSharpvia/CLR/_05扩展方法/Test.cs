using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05扩展方法
{
    public static class Test
    {
        public static void ActionExtend<T>(this Action<object> f, object o) where T : Exception, new()
        {
            try
            {
                f(o);
            }
            catch (T e)
            {
                throw new T();
            }
        }
    }
}
