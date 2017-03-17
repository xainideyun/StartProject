using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11接口
{
    class Program
    {
        static void Main(string[] args)
        {
            Student s = new Student();
            Console.WriteLine(s.MyTypeName<Person>());

            MyCompare mc = new MyCompare(29);
            mc.CompareTo(new MyCompare(22));

            Console.ReadKey();
        }
    }

    interface MyInterface
    {
        string MyTypeName<T>() where T : Person;
    }

    class Person
    {
        public string Name { get; set; }
        public int Age { get; set; }
    }

    class Student : Person, MyInterface
    {
        public string Number { get; set; }
        public virtual string MyTypeName<T>() where T : Person
        {
            return typeof(T).Name;
        }
    }

    class Son : Student
    {
        public override string MyTypeName<T>()
        {
            return base.MyTypeName<T>();
        }
    }

}
