using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestNinject
{
    public interface IDataBase
    {
        void Add();
        void Delete();
        void Update();
        void Select();
        void Show();
    }
}
