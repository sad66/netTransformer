package net.itransformers.assertions;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * Created with IntelliJ IDEA.
 * User: VasilYordanov
 * Date: 6/16/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class AssertionExecutorTestCase {
    private String versionDir = "iAssertions/src/main/resources/network/version3";
    @Test
    public void testExecute() throws Exception {
        AssertionExecutor executor = new AssertionExecutor();
        File assertionsConfig = new File("iAssertions/src/test/java/net/itransformers/assertions/test-assertions-config.xml");
        File[] inputFiles = new File[]{new File("iAssertions/src/test/java/net/itransformers/assertions/impl/xpath-test.xml")};
        File folder = new File(".");

        AssertionResult[] result = executor.execute(inputFiles, assertionsConfig, AssertionLevel.CRITICAL);
        Assert.assertEquals(3,result.length);
        for (AssertionResult assertionResult : result) {
            Assert.assertEquals(assertionResult.getType(),AssertionType.SUCCESS);
        }
    }
    @Test
    public void testExecute1() throws Exception {
        AssertionExecutor executor = new AssertionExecutor();
        File assertionsConfig = new File("iAssertions/src/test/java/net/itransformers/assertions/test-assertions-config.xml");
        final File folder = new File(versionDir);
        File[] inputFiles =folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".graphml") ;
            }
        });

       // File[] inputFiles = new File[]{new File("iAssertions/src/test/java/net/itransformers/assertions/impl/xpath-test.xml")};
        AssertionResult[] result = executor.execute(inputFiles, assertionsConfig, AssertionLevel.CRITICAL);
//        Assert.assertEquals(3,result.length);
        for (AssertionResult assertionResult : result) {
            Assert.assertEquals(assertionResult.getType(),AssertionType.SUCCESS);
        }
    }
}
