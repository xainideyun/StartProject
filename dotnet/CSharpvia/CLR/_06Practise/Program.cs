using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace _06Practise
{
    class Program
    {
        static void Main(string[] args)
        {

            var a = DiyTuple.MinMax(222, 3);

            byte[] buffer = new byte[129 / 8];
            

            MyDic<string> bbb = new MyDic<string>() { {"dd", "ww" } };
            var ddd = Newtonsoft.Json.JsonConvert.SerializeObject(bbb);

            Abc<Stream, FileStream> tt = null;
            Abc<FileStream, Stream> dd = tt;



            Console.WriteLine(Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments));
            Console.ReadKey();
        }
    }

    class MyDic<TValue> : Dictionary<string, TValue>
    {
        public string Name { get; set; }
    }

    public delegate TResult Abc<in T, out TResult>(T g);


}
