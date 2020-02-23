package com.slowgenius.thread.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author slowgenius
 * @date 2/21/2020 3:28 PM
 * @description
 */
public class DbPool {

    private static LinkedList<Connection> pool = new LinkedList<>();

    public DbPool(int initialize) {
        for (int i = 0; i < initialize; i++) {
            pool.addLast(ConnectionImpl.fetchConnection());
        }
    }

    public Connection ferchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long overTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = overTime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }

        }

    }

    public void releaseConn(Connection conn) {
        if (conn != null) {
            synchronized (pool) {
                pool.addLast(conn);
                notifyAll();

            }
        }
    }
}