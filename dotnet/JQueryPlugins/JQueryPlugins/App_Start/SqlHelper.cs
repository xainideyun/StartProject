using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace JQueryPlugins.App_Start
{
    public class SqlHelper
    {
        private static string _connStr = "server=.;database=H3;uid=sa;pwd=sa";

        /// <summary>
        /// 执行sql语句，返回受影响行数
        /// </summary>
        /// <param name="sql">执行的sql</param>
        /// <param name="param">sql参数</param>
        /// <returns></returns>
        public static int ExcuteNonQuery(string sql, params SqlParameter[] param)
        {
            using (IDbConnection conn = new SqlConnection(_connStr))
            {
                conn.Open();
                using (IDbCommand command = conn.CreateCommand())
                {
                    if (param != null)
                    {
                        foreach (var item in param)
                        {
                            command.Parameters.Add(item);
                        }
                    }
                    command.CommandText = sql;
                    return command.ExecuteNonQuery();
                }
            }
        }
        /// <summary>
        /// 执行查询，返回数据表
        /// </summary>
        /// <param name="sql">执行的sql</param>
        /// <param name="param">sql参数</param>
        /// <returns></returns>
        public static DataTable ExcuteTable(string sql, params SqlParameter[] param)
        {
            using (IDbConnection conn = new SqlConnection(_connStr))
            {
                conn.Open();
                using (IDbCommand command = conn.CreateCommand())
                {
                    if (param != null)
                    {
                        foreach (var item in param)
                        {
                            command.Parameters.Add(item);
                        }
                    }
                    command.CommandText = sql;
                    var dataReader = command.ExecuteReader();
                    if (dataReader == null) return null;
                    DataTable table = new DataTable();
                    table.Load(dataReader);
                    return table;
                }
            }
        }

        public static List<T> ExcuteTable<T>(string sql, Func<DataRow, T> handler, params SqlParameter[] param)
        {
            var table = ExcuteTable(sql, param);
            if (table == null) return null;
            return table.Select().Select(handler).ToList();
        }

        /// <summary>
        /// 执行查询，返回结果
        /// </summary>
        /// <param name="sql">执行的sql</param>
        /// <param name="param">sql参数</param>
        /// <returns></returns>
        public static object ExcuteScalar(string sql, params SqlParameter[] param)
        {
            using (IDbConnection conn = new SqlConnection(_connStr))
            {
                conn.Open();
                using (IDbCommand command = conn.CreateCommand())
                {
                    if (param != null)
                    {
                        foreach (var item in param)
                        {
                            command.Parameters.Add(item);
                        }
                    }
                    command.CommandText = sql;
                    return command.ExecuteScalar();
                }
            }
        }

    }
}