package pers.chenmo.Myapp.User;

/* 1.编写程序实现简单的登录注册功能。程序包含以下4个功能：
（1）登录功能，用户输入正确的账号密码进行登录；
（2）注册功能，输入用户名和密码进行注册；
（3）查看功能，查看所有的用户名与密码；
（4）退出功能，退出系统。
用户可以输入对应的编号进行相应的功能操作。例如，输入2进入注册功能，输入用户名和密码进行注册。 
 */
import java.util.*;

class User {
  public String username;
  public String passworld;
  String logName;
  public String[] UserInfo;

  ArrayList<String> UnameList;
  ArrayList<String> UpwList;
  int index;
  Scanner sc;
  boolean flag;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassworld() {
    return passworld;
  }

  public void setPassworld(String passworld) {
    this.passworld = passworld;
  }

  public String[] getUserInfo() {
    return UserInfo;
  }

  public void setUserInfo(String[] userInfo) {
    UserInfo = userInfo;
  }

  public String[] getUnameList() {
    return UserInfo;
  }

  public ArrayList<String> setUnameList(String username) {
    UnameList.add(username);
    return UnameList;
  }

  public ArrayList<String> getUpwList() {
    return UpwList;
  }

  public ArrayList<String> setUpwList(String password) {
    UpwList.add(password);
    return UpwList;

  }

  public User() {

  }

  public User(ArrayList<String> UnameList, ArrayList<String> UpwList, Scanner sc) {
    this.UpwList = UpwList;
    this.UnameList = UnameList;
    this.sc = sc;

  }

  void logiIn(User u1) {
    if (flag) {
      System.out.println("您已经登录账号" + this.logName);
      this.begin(u1);

    } else {
      if (UnameList.size() <= 0) {
        System.out.println("当前系统没有用户,请先注册！");
        this.signIn(u1);
      } else {
        System.out.println("用户开始登录");

        System.out.println("请输入用户名");
        setUsername(sc.next());

        for (int i = 0; i < UnameList.size(); i++) {

          if (UnameList.get(i).equals((this.username))) {

            System.out.println("请输入密码");

            setPassworld(sc.next());
            if (UpwList.get(i).equals(this.passworld)) {

              this.logName = UnameList.get(i);
              System.out.println(UnameList.get(i) + "登陆成功");
              this.flag = true;
              this.begin(u1);
              break;
            } else {
              System.out.println("密码输入错误，请重新输入");
              this.logiIn(u1);
            }
          } else {
            if (i >= UnameList.size() - 1) {
              System.out.println("您还没有创建该用户！");
              this.begin(u1);
            }
          }

        }

      }

    }
  }

  void signIn(User u1) {
    System.out.println("用户开始注册");
    System.out.println("请输入用户名");
    this.setUsername(sc.next());
    this.setUsername(username);
    this.setUnameList(username);

    System.out.println("请输入密码");
    this.setPassworld(sc.next());
    this.setPassworld(passworld);
    this.setUpwList(passworld);

    this.begin(u1);
  }

  void cat(User u1) {
    if (UnameList.size() <= 0) {
      System.out.println("当前没有用户,请注册");
      this.signIn(u1);
    }
    System.out.println("用户列表:");
    for (int i = 0; i < UnameList.size(); i++) {
      System.out.println(i + " 用户 " + UnameList.get(i) + "密码" + UpwList.get(i));

    }
    this.begin(u1);
  }

  void quit(User u1) {
    if (flag) {
      this.flag = false;
      System.out.println("退出账号" + logName + "成功！");

      this.logName = null;
    } else {
      System.out.println("您还没有登录账户");

    }
    System.out.println("是否退出系统？Y/N");
    String flagQ = sc.next();
    if (flagQ.equals("Y") || flagQ.equals("y")) {
      System.out.println("退出系统成功");

    } else if (flagQ.equals("N") || flagQ.equals("n")) {
      this.begin(u1);
    } else {
      System.out.println("请输入正确格式 Y/N");
      this.quit(u1);
    }

  }

  void begin(User u1) {
    System.out.println("请输入编号 1登录 2注册 3查看 4退出");
    int choice = sc.nextInt();

    if (choice == 1) {
      this.logiIn(u1);
    } else if (choice == 2) {
      this.signIn(u1);

    } else if (choice == 3) {
      this.cat(u1);
    } else if (choice == 4) {
      this.quit(u1);
    } else {
      System.out.println("请输入正确编号！");

    }
  }
}

class test1 {
  public static void main(String[] args) {
    ArrayList<String> UnameList = new ArrayList<>();
    ArrayList<String> UpwList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    User u1 = new User(UnameList, UpwList, sc);
    u1.begin(u1);
  }
}