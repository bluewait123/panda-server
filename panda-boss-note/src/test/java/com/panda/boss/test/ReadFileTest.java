package com.panda.boss.test;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileTest {
    public static void main(String[] args) throws Exception {
        String templateFile = "/Users/wujianhui/work/project/panda/panda-boss-note/config/markdown_template.html";
        List<String> data = Files.readAllLines(Paths.get(templateFile), StandardCharsets.UTF_8);
        String markdownData = "# git使用笔记\\n\\n标签（空格分隔）： git\\n###### create date : 2018-09-27 20:52:26\\n---\\n### 一、安装git\\n    Ubuntu 安装 Git： apt-get install git  \\n    CentOS 安装 Git： yum install git  \\n    查看 Git 版本信息： git version  \\n### 二、配置本地git账号\\n    git config --global user.email \\\"you@example.com\\\"\\n    git config --global user.name \\\"Your Name\\\"\\n### 三、开启SSH服务\\n    [如果已经开启SSH,请跳过此步骤]\\n    Ubuntu 安装 SSH：  apt-get install ssh \\n    查看 SSH 服务状态： ps -e | grep sshd\\n### 四、生成SSH KEY\\n    ssh-keygen -t rsa -C \\\"you@example.com\\\"\\n    生成 ssh key 过程中，会让你填写 passphrase，按回车Enter设置空密码\\n### 五、查看生成的SSH KEY文件\\n    cd ~/.ssh\\n>*.ssh目录\\n>id_rsa\\n>id_rsa.pub\\n\\n### 六、复制 SSH KEY\\n    more id_ras.pub\\n    得到:\\n    ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCt2Fxo60NeqW0nSwtss5zT7XM9E8FFrJt3/z9vYMBazNTc8Y88FtEqlCNtTl6HLlT8SgFc7YSDTkYm9HvLcQ3YX2PjFCycAABDALD3g5zeaP1tbUfvSpO4EOGwAqol01u196tev7q5GufImn9gxYhIme55qFVA2PutHFvG83Wy3D6Mn4FCcz+3bHki8OZBWnyr0BHiY7s9ZTn0JPQnVeyP7F6PFUQ84lOyUVvifG/Vvd5DimUOJ0ginVuSZpBDbOi0qYWX1q9Jqpd10zrkM6FtjKQt6aZHyL3y3481Htz8morzjuXe5/XldNvI2whuOAfGoV5IfKBgKrHv+qh8+fbD you@example.com\\n### 七、设置 SSH KEY\\n    1) 登录github ，选择Settings，选择SSH and GPG keys\\n    2) 选择 NEW SSH key 按钮\\n    3) Key输入刚刚生成的id_ras.pub内容\\n    4) 选择Add SSH key按钮进行保存\\n### 八、创建GitHub仓库\\n    1) 选择New repository\\n    2) 输入Repository name资源仓库名称\\n    3）选择Public 公共仓库\\n    4) 选择Create repository 创建仓库\\n    5) 得到仓库的HTTPS和SSH地址\\n### 九、克隆仓库到本地\\n    git clone git@github.com:*/*.git\\n### 十、常用命令\\n    添加文件 git add readme.md\\n    提交文件到git本地库 git commit -m \\\"add readme file\\\"\\n    上传到git远程库 git push\\n    查看分支列表 git branch -a\\n    创建本地分支 git checkout -b test\\n    提交本地分支到远程库 git push origin test\\n    合并主分支到test分支 git branch --set-upstream-to=origin/test\\n    更新分支文件到本地 git pull\\n    切换分支 git checkout master\\n    查看文件状态 git status\\n    添加所有文件 git add .\\n    撤销合并文件 git checkout [branch/tag] 文件路径+文件名\\n\\n### git 常用命令速查表\\n    * 创建版本库\\n    git clone [url]                     #克隆远程版本库\\n    git init                            #初始化本地版本库\\n    \\n    *修改和提交\\n    git status                          #查看状态\\n    git diff                            #查看变更内容\\n    git add .                           #跟踪所有改动过的文件\\n    git add [file]                      #跟踪指定的文件\\n    git mv [old] [new]                  #文件改名\\n    git rm [file]                       #删除文件\\n    git rm --cached [file]              #停止跟踪文件但不删除\\n    git commit -m \\\"commit messages\\\"     #提交所有更新过的文件\\n    git commit --amend                  #修改最后一次改动\\n    \\n    * 查看提交历史\\n    git log                             #查看提交历史\\n    git log -p [file]                   #查看指定文件的提交历史\\n    git blame [file]                    #以列表方式查看指定文件的提交历史\\n\\n    * 撤销\\n    git reset --hard HEAD               #撤销工作目录中所有未提交文件的修改内容\\n    git checkout HEAD [file]            #撤销指定的未提交文件的修改内容\\n    git revert [commit]                 #撤销指定的提交\\n    git log --before=\\\"1 days\\\"           #退回到之前1天的版本\\n\\n    * 分支与标签\\n    git branch                          #显示所有本地分支\\n    git checkout [branch/tag]           #切换到指定分支和标签\\n    git branch [new-branch]             #创建新分支\\n    git branch -d [branch]              #删除本地分支\\n    git tag                             #列出所有本地标签\\n    git tag [tagname]                   #基于最新提交创建标签\\n    git tag -d [tagname]                #删除标签\\n\\n    * 合并与衍合\\n    git merge [branch]                  #合并指定分支到当前分支\\n    git rebase [branch]                 #衍合指定分支到当前分支\\n    \\n    * 远程操作\\n    git remote -v                       #查看远程版本库信息\\n    git remote show [remote]            #查看指定远程版本库信息\\n    git remote add [remote] [url]       #添加远程版本库\\n    git fetch [remote]                  #从远程库获取代码\\n    git pull [remote] [branch]          #下载代码及快速合并\\n    git push [remote] [branch]          #上传代码及快速合并\\n    git push [remote] :[branch/tag-name]#删除远程分支或标签\\n    git push --tags                     #上传所有标签\\n    \\n### git 多账号配置\\n#### 1.取消git全局设置\\n    git config --global --unset user.name    \\n    git config --global --unset user.email\\n    \\n#### 若已下载的项目提示找不到email或者每次clone项目后，需配置email\\n    为每个项目单独配置 user.name 和 user.email\\n    git config user.name \\\"yourname\\\"\\n    git config user.email \\\"youremail\\\"\\n    \\n#### 2.生成ssh key\\n\\n##### 2.1 先假设我有两个账号，一个是github上的，一个是公司gitlab上面的。先为不同的账号生成不同的ssh-key\\n    ssh-keygen -t rsa -f ~/.ssh/id_rsa_github -C xxx@gmail.com\\n    ssh-keygen -t rsa -f ~/.ssh/id_rsa_company -C xxx@gmail.com\\n    \\n##### 2.2 把id_rsa_xxx.pub中的key添加到github或gitlab上\\n    1) 登录github ，选择Settings，选择SSH and GPG keys\\n    2) 选择 NEW SSH key 按钮\\n    3) Key输入刚刚生成的id_ras.pub内容\\n    4) 选择Add SSH key按钮进行保存\\n    \\n#### 3.编辑 ~/.ssh/config，设定不同的git 服务器对应不同的key\\n    #my git\\n    Host github.com\\n    HostName github.com\\n    User github\\n    IdentityFile ~/.ssh/id_rsa_github\\n    \\n    #company\\n    Host gitlab.f-road.com.cn\\n    HostName gitlab.f-road.com.cn\\n    User company\\n    IdentityFile ~/.ssh/id_rsa_company\\n    \\n    编辑完成后可以使用命令 ssh -vT git@github.com\\n    看看是不是采用了正确的id_rsa_github.pub文件\\n    \\n    这样每次push的时候系统就会根据不同的仓库地址使用不同的账号提交了";
        for(int i=0;i<data.size();i++){
            if("markdown : '',".equals(data.get(i).trim())){
                data.set(i,"markdown : '" + markdownData + "',");
                break;
            }
        }

        String fileName = "/Users/wujianhui/work/project/panda/panda-boss-note/config/new.html";
        try(FileOutputStream out = new FileOutputStream(fileName)) {
            for(String row : data){
                out.write(row.getBytes(StandardCharsets.UTF_8));
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        String mdFile = "/Users/wujianhui/work/project/panda/panda-boss-note/config/new.md";
        try(FileWriter fileWriter = new FileWriter(mdFile)){
            fileWriter.write(markdownData);
            fileWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
