package com.utils;

/**
 * @Description
 * @date 2022-08-22 23:17
 * @Author fanxg
 * oracle工具类
 */
public class OracleUtils {

    //sql语句

    //Oracle单表备份三种方案
    //参考文章：
    //https://www.cnblogs.com/kakaisgood/p/11388476.html
    /**
     *方案一：此种情况适用于，同一个数据库，需要备份某张表。
     *备份
     * create table [备份名] as select * from [表名];
     *
     * 恢复
     * truncate table org_group;
     * insert into org_group select * from [备份名] ;
     *
     */

    /**
     * 方案二：
     *
     * 备份
     * oracle用户终端执行：
     * exp [用户名]/[密码] tables=[表一],[表二] file=/home/oracle/table.dmp
     *
     * 恢复
     * oracle用户终端执行：
     * imp [用户名]/[密码] grants=y commit=y full=y ignore=y file=/home/oracle/table.dmp
     */

    /**
     *方案三：
     *
     * 备份
     *
     * 登录sqlplus:
     * sqlplus / as sysdba
     *
     * 创建directory：
     * create directory dpdata as '/home/oracle/';
     *
     * 目录创建以后，就可以把读写权限授予特定用户：
     * grant read, write on directory dpdata to [用户名];
     *
     * oracle用户终端执行：
     * expdp [用户名]/[密码] tables=[表一],[表二] directory=dpdata dumpfile=table.dmp job_name=cases_export
     *
     *
     * 恢复
     *
     * 登录sqlplus :
     * sqlplus / as sysdba
     *
     * 创建directory：
     * create directory dpdata as '/home/oracle/';
     *
     * 目录创建以后，就可以把读写权限授予特定用户：
     * grant read, write on directory dpdata to [用户名];
     *
     * oracle用户终端执行：
     * impdp [用户名]/[密码] directory=dpdata dumpfile=table.dmp job_name=cases_export
     */

    /**
     * 查询dba_directories查看所有directory：
     * select * from dba_directories;
     *
     * 删除directory：
     * drop directory dpdata;
     */

}
