/*����*/
interface In1
{
  void show1();
}
interface In2
{
  void show2();
}
interface In3
{
  void show3();
}
class InClass1 implements In1,In2,In3
{
  public void show1(){System.out.println("�ӿڵķ���1");}
  public void show2(){System.out.println("�ӿڵķ���2");}
  public void show3(){System.out.println("�ӿڵķ���3");}
}
interface In4 extends In1,In2,In3
{
  void show4();
}
class InClass2 implements In4
{
  public void show1(){System.out.println("�ӿڵķ���һ");}
  public void show2(){System.out.println("�ӿڵķ�����");}
  public void show3(){System.out.println("�ӿڵķ�����");}
  public void show4(){System.out.println("�ӿڵķ�����");}
}

class InterfaceDemo1
{
  public static void main(String[] args)
  {
    InClass1 ic = new InClass1();
    ic.show1();
    ic.show2();
    ic.show3();
    InClass2 ic2 = new InClass2();
    ic2.show1();
    ic2.show2();
    ic2.show3();
    ic2.show4();
  }
}
