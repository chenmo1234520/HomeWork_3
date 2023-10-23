package pers.chenmo.Myapp.Watch;

/* 2.在一些节目活动中，经常会有抽取幸运观众环节。本案例要求编写程序实现幸运观众的抽取，在指定人群中随机抽取一名幸运观众。
案例功能要求如下：
从键盘输入3名观众。
存储观众姓名。
总览观众姓名。
随机选取一名观众，并打印出该观众姓名。
 */
import java.util.*;

class Person {
  String name;
  String[] perList;
  int randomNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getPerList() {
    return perList;
  }

  public void setPerList(int i, String name) {
    this.perList[i] = this.name;
  }

  Scanner sc;

  public Person(String[] perList, Scanner sc) {
    this.perList = perList;
    this.sc = sc;
  }

  void ipt() {

    for (int i = 0; i <= perList.length - 1; i++) {

      int index = i + 1;
      System.out.println("请输入第" + index + "位观众姓名");
      setName(sc.next());
      save(i, index);

    }

  }

  void save(int i, int index) {

    setPerList(i, name);
    System.out.println(index + "号观众记录完毕");

  }

  void cat() {
    System.out.println("总览观众姓名");

    for (int i = 0; i < perList.length; i++) {
      int index = i + 1;
      System.out.println(index + "号观众" + perList[i]);

    }
  }

  void random(String[] list) {
    Random randomNumber = new Random();
    int random = randomNumber.nextInt(3);
    System.out.println("随机选取一名观众是" + perList[random]);

  }
}

public class test2 {
  public static void main(String[] args) {
    String[] perList = new String[3];
    Scanner sc = new Scanner(System.in);
    Person p = new Person(perList, sc);
    p.ipt();
    p.cat();
    p.random(perList);
  }
}
