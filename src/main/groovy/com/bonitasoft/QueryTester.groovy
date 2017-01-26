package com.bonitasoft

import groovy.sql.Sql

/**
 * @author Baptiste Mesta
 */
class QueryTester {

    public static void main(String[] args) {
        if (args.size() != 5) {
            println "Usage: query-tester <url> <usr> <pass> <counter> <sleep>"
            System.exit(1)
        }
        def counter = Integer.valueOf(args[3])
        def sleep = Integer.valueOf(args[4])
        def Sql sql = Sql.newInstance(args[0], args[1], args[2])
        try {
            for (int i = 1; i <= counter; i++) {

                def start = System.currentTimeMillis()
                sql.execute("select * from ( select seventtrig0_.tenantid as tenantid1_26_,\n" +
                        "seventtrig0_.id as id2_26_, seventtrig0_.eventInstanceId as eventIns4_26_, seventtrig0_.executionDate as executio5_26_,\n" +
                        "seventtrig0_.jobTriggerName as jobTrigg6_26_, seventtrig0_.eventInstanceName as eventIns7_26_,\n" +
                        "seventtrig0_.messageName as messageN8_26_, seventtrig0_.targetProcess as targetPr9_26_,\n" +
                        "seventtrig0_.targetFlowNode as targetF10_26_, seventtrig0_.signalName as signalN11_26_,\n" +
                        "seventtrig0_.errorCode as errorCo12_26_, seventtrig0_.kind as kind3_26_\n" +
                        "from event_trigger_instance seventtrig0_ where 1 = seventtrig0_.tenantid\n" +
                        "and seventtrig0_.eventInstanceId=9 order by seventtrig0_.id ASC ) where rownum <= 1000")
                println System.currentTimeMillis() - start
                Thread.sleep(sleep)
            }
        } finally {
            sql.close()
        }
    }
}
