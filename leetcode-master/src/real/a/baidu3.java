package real.a;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*
输入描述
第一行输入一个正整数n，代表表的数量。
接下来的若干行用来表示这n个表。
每个表首先是一行字符串代表表的名字。
然后输入两个正整数a,b，代表表的记录数量和字段数量。

接下来的a+1行，每行输入b个字符串。用来描述表的内容：
第一行是表头，代表字段名。
其余的a行，每行代表一条记录。表示这个记录的每个字段值。
我们定义，第一列的字段为该表的主键。
n个表都输入完后，接下来的一行输入一个正整数q，代表sql语句的数量。

语句共有两种：
第一种是查询语句，格式是"select [str1,str2,……] from [table];"，其中str1..n 代表字段名，table代表表的名字。
第二种是修改语句，格式是"update [table] set [str1]=[a1] where [str2]=[a2];"。其中table为表的名字，str1代表待修改的字段名，a1为修改后的字段值，str2为主键的字段名，a2代表该主键的字段值。

我们保证，所有的操作都是合法的。
表的数量、表的记录数量和字段数量、操作的语句数量均不超过10（保证至少有一个查询语句），所有字段名、表名均为长度不超过20的、仅由英文小写字母组成的字符串，所有字段值均为长度不超过20的、仅由数字字符或英文字母组成的字符串。
保证每个表的第一列为主键。保证修改语句的str2为主键名字。保证同一个表的主键不存在重复字符串。

请注意，语句中可能多存在多余的空格，并不影响语句的执行！
输出描述
对于每次查询语句，输出查询的结果：输出对应的表的信息，共a+1行，第一行为查询的字段名，后面的a行代表每条记录的数据，列数等于查询的字段数量。
具体格式见样例。
示例1
输入输出示例仅供调试，后台判题数据一般不包含示例

输入
2
student
3 3
studentid name score
2017011111 ranko 97
0123456789 kotori 99
9876543210 yukari 60
lesson
3 2
lessonid name
1 math
2 phsycology
3 phylosophy
5
select name,score from student;
update student set score = 90 where studentid =9876543210;
select studentid, score from student;
update lesson set name=yuwen where lessonid=1;
select lessonid,name from lesson;

输出
name score
ranko 97
kotori 99
yukari 60
studentid score
2017011111 97
0123456789 99
9876543210 90
lessonid name
1 yuwen
2 phsycology
3 phylosophy
* */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baidu3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, Table> tables = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tableName = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Table table = new Table(tableName, a, b);
            for (int j = 0; j < b; j++) {
                table.addColumn(scanner.next());
            }
            for (int j = 0; j < a; j++) {
                Record record = new Record();
                for (int k = 0; k < b; k++) {
                    record.addColumn(scanner.next());
                }
                table.addRecord(record);
            }
            tables.put(tableName, table);
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine().trim();
            if (query.startsWith("select")) {
                String[] parts = query.split(" ");
                String tableName = parts[parts.length - 1].replace(";", "");
                Table table = tables.get(tableName);
                String[] columns = parts[1].replace("select ", "").replace(";", "").split(",");
                table.select(columns);
            } else if (query.startsWith("update")) {
                String[] parts = query.split(" ");
                String tableName = parts[1];
                Table table = tables.get(tableName);
                String columnToUpdate = parts[3].replace("=", "");
                String newValue = parts[4];
                String primaryKeyColumn = parts[6].replace("=", "");
                String primaryKeyValue = parts[7].replace(";", "");
                table.update(columnToUpdate, newValue, primaryKeyColumn, primaryKeyValue);
            }
        }
    }

    static class Table {
        private final String name;
        private final int rows;
        private final int columns;
        private final Map<String, Integer> columnNamesToIndex;
        private final Record[] records;

        public Table(String name, int rows, int columns) {
            this.name = name;
            this.rows = rows;
            this.columns = columns;
            this.columnNamesToIndex = new HashMap<>();
            this.records = new Record[rows];
        }

        public void addColumn(String columnName) {
            columnNamesToIndex.put(columnName, columnNamesToIndex.size());
        }

        public void addRecord(Record record) {
            records[records.length - rows] = record;
        }

        public void select(String[] columns) {
            StringBuilder sb = new StringBuilder();
            for (String column : columns) {
                sb.append(column).append(" ");
            }
            System.out.println(sb.toString().trim());
            for (Record record : records) {
                sb.setLength(0);
                for (String column : columns) {
                    sb.append(record.getColumn(columnNamesToIndex.get(column))).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }

        public void update(String columnToUpdate, String newValue, String primaryKeyColumn, String primaryKeyValue) {
            for (Record record : records) {
                if (record.getColumn(columnNamesToIndex.get(primaryKeyColumn)).equals(primaryKeyValue)) {
                    record.setColumn(columnNamesToIndex.get(columnToUpdate), newValue);
                    break;
                }
            }
        }
    }

    static class Record {
        private final String[] columns;

        public Record() {
            this.columns = new String[100];
        }

        public void addColumn(String value) {
            columns[columns.length - getNumberOfColumns()] = value;
        }

        public void setColumn(int index, String value) {
            columns[index] = value;
        }

        public String getColumn(int index) {
            return columns[index];
        }

        private int getNumberOfColumns() {
            for (int i = 0; i < columns.length; i++) {
                if (columns[i] == null) {
                    return i;
                }
            }
            return columns.length;
        }
    }
}



