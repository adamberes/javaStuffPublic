package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3 {
    
    public Ex3() {
    }
    private List<PathElement>  buildPathElementList(String stringBase) {
        List<String> pathInListBase = Arrays.asList(stringBase.split("\\\\"));
        return  pathInListBase.stream()
                .map(p -> new PathElement(p, pathInListBase.indexOf(p)))
                .collect(Collectors.toList());
    }

    private List<PathElement>  pathPathElementSubstraction(List<PathElement> pathElementListBase, List<PathElement> pathElementList)
    {
        return pathElementList.stream()
                .filter(two -> pathElementListBase.stream()
                .noneMatch(one -> (one.name().equals(two.name()) && one.order() == two.order())))
                .distinct().collect(Collectors.toList());
    }
    private String buildPathFromPathElement(List<PathElement> pathElementListRest) {
        StringBuilder stringArray00 = new StringBuilder();
        pathElementListRest.forEach(s -> stringArray00.append(s.name() + "\\"));
        return stringArray00.toString();
    }

    public String pathAddition(String s1, String s2){
        if( !s1.endsWith("\\") && !s2.startsWith("\\")) { s2 = "\\" + s2; }
        List<PathElement> pathElementList = buildPathElementList(new StringBuilder().append(s1).append(s2).toString());
        return buildPathFromPathElement( pathElementList);
    }

    public String pathSubtraction(String basePath, String path){
        boolean debug = false;//include conditional debug with true
        List<PathElement> pathElementListBase = buildPathElementList(basePath);
        if(debug) {
            System.out.println("pathElementListBase:" + pathElementListBase);
            System.out.println();
        }
        List<PathElement> pathElementList = buildPathElementList(path);
        if(debug) {
            System.out.println("pathElementList:" + pathElementList);
            System.out.println();
        }
        List<PathElement> pathElementListRest = pathPathElementSubstraction(pathElementListBase, pathElementList);
        if(debug) {
            System.out.println("pathElementListRest:" + pathElementListRest);
            System.out.println();
        }
        return buildPathFromPathElement( pathElementListRest);
    }

    public static void main(String[] args) {
        Ex3 ex3 = new Ex3();
        String stringBase = "C:\\Users";
        String string     = "C:\\Users\\Adam Beres\\OneDrive\\Bilder\\ControlCenter4\\Scan\\";
        String stringExpectedResult = "Bilder\\ControlCenter4\\Scan\\";
        long start = System.nanoTime();
        String resultPath = ex3.pathSubtraction(stringBase, string);
        String stringAdded = ex3.pathAddition(stringBase, resultPath);
        long end = System.nanoTime();
        System.out.println("Computation took " + (end - start)/1_000_000 + " ms");
        System.out.println("---------------------------");
        System.out.println("Subtract result Path      = " + resultPath);
        System.out.println("stringArrayResultExpected = " + stringExpectedResult);
        System.out.println("Add string                = " + string);
        System.out.println("stringAdded               = " + stringAdded);
        //Computation took 117461 ms
        //Computation took 49627 ms
    }
}
