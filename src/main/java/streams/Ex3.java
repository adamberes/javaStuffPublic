package streams;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex3 {

    private List<PfadElement>  buildPathElementList(String stringBase) {
        List<String> pathInListBase = Arrays.asList(stringBase.split("\\\\"));
        return  pathInListBase.stream()
                .map(p -> new PfadElement(p, pathInListBase.indexOf(p)))
                .collect(Collectors.toList());
    }

    private List<PfadElement>  pathPathElementSubstraction(List<PfadElement> pathElementListBase, List<PfadElement> pathElementList)
    {
        return pathElementList.stream()
                .filter(two -> pathElementListBase.stream()
                .noneMatch(one -> (one.getName().equals(two.getName()) && one.getOrder() == two.getOrder())))
                .distinct().collect(Collectors.toList());
    }
    private String buildPathFromPathElement(List<PfadElement> pathElementListRest) {
        StringBuilder stringArray00 = new StringBuilder();
        pathElementListRest.forEach(s -> stringArray00.append(s.getName() + "\\"));
        return stringArray00.toString();
    }

    public String pathAddition(String s1, String s2){
        if( !s1.endsWith("\\") && !s2.startsWith("\\")) { s2 = "\\" + s2; }
        List<PfadElement> pathElementList = buildPathElementList(new StringBuilder().append(s1).append(s2).toString());
        return buildPathFromPathElement( pathElementList);
    }
    public Ex3() {
    }
    public String pathSubtraction(String basePath, String path){
        boolean debug = false;//include conditional debug with true
        List<PfadElement> pathElementListBase = buildPathElementList(basePath);
        if(debug) {
            System.out.println("pathElementListBase:" + pathElementListBase);
            System.out.println();
        }

        List<PfadElement> pathElementList = buildPathElementList(path);
        if(debug) {
            System.out.println("pathElementList:" + pathElementList);
            System.out.println();
        }

        List<PfadElement> pathElementListRest = pathPathElementSubstraction(pathElementListBase, pathElementList);
        if(debug) {
            System.out.println("pathElementListRest:" + pathElementListRest);
            System.out.println();
        }
        return buildPathFromPathElement( pathElementListRest);

    }

    public static void main(String[] args) {
       Ex3 ex3 = new Ex3();
        String stringBase = "C:\\Users\\Adam Beres";
        String string     = "C:\\Users\\Adam Beres\\OneDrive\\Bilder\\ControlCenter4\\Scan\\";
        String stringExpectedResult = "OneDrive\\Bilder\\ControlCenter4\\Scan\\";
        String resultPath = ex3.pathSubtraction(stringBase, string);
        String stringAdded = ex3.pathAddition(stringBase, resultPath);
        System.out.println("string                    = " + string);
        System.out.println("stringAdded               = " + stringAdded);
        System.out.println("---------------------------");
        System.out.println("resultPath                = " + resultPath);
        System.out.println("stringArrayResultExpected = " + stringExpectedResult);

    }
}
