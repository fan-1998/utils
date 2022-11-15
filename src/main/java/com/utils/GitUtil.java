package com.utils;

/**
 * @Description
 * @date 2022-08-21 20:51
 * @Author fanxg
 * Git常用命令
 */
public class GitUtil {
    /**
     * 设置用户签名
     * git config --global user.name 用户名
     *
     * 设置用户签名
     * git config --global user.email 邮箱
     *
     * 初始化本地库
     * git init
     *
     * 查看本地库状态
     * git status
     *
     * 添加到暂存区
     * git add 文件名
     *
     * 一次性全部提交暂存区
     * git add .
     *
     * 提交到本地库
     * git commit -m "日志信息" 文件名
     *
     * 查看历史记录
     * git reflog
     *
     * 查看历史记录（简易版）
     * git log
     *
     * 版本穿梭
     * git reset --hard 版本号
     *
     * 创建分支
     * git branch 分支名
     *
     * 查看分支
     * git branch -v
     *
     * 切换分支
     * git checkout 分支名
     *
     * 把指定的分支合并到当前分支上
     * git merge 分支名
     */

    //合并分支出现冲突
    /**
     * 1、编辑有冲突的文件，删除特殊符号，决定要使用的内容
     * 2、添加到暂存区
     * git add XXXXX.txt
     * 3、执行提交（注意：此时使用 git commit 命令时不能带文件名）
     *  git commit -m "提交XXXXX"
     */

    //远程仓库操作
    /**
     * 查看当前所有远程地址别名
     * git remote -v
     *
     * 起别名
     * git remote add 别名 远程地址
     *
     * 推送本地分支上的内容到远程仓库
     * git push 别名 分支
     *
     * 将远程仓库的内容克隆到本地
     * git clone 远程地址
     *
     * 将远程仓库对于分支最新内容拉下来后与当前本地分支直接合并
     * git pull 远程库地址别名 远程分支名
     */
}
