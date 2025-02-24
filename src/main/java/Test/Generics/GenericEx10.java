package Test.Generics;
/*
ClassLoader - что это такое?
*/




import java.util.Set;

public class GenericEx10 {

    public static void main(String[] args) {
        Set<? extends Animal> allAnimals =
                getAllAnimals(GenericEx10.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                        GenericEx10.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        return null;
    }
}


 interface Animal {
}

class Sheep implements Animal {
    private Sheep() {
    }

    public Sheep(Integer integer) {
    }
}


 class Elephant {
    private Elephant() {
    }
}


 class Cat1 implements Animal {
    public Cat1() {
    }
}



//HARD ClassLoader - что это такое?
//
//Реализуй логику метода getAllAnimals.
//Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
//Путь не обязательно содержит / в конце.
//НЕ все классы наследуются от интерфейса Animal.
//НЕ все классы имеют публичный конструктор без параметров.
//Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
//Добавить созданные объекты в результирующий сет и вернуть.
//Метод main не участвует в тестировании.


//Требования:
//        •	•
//Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов поддерживающих интерфейс Animal
// и имеющих публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).
//        •	•
//В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие интерфейс Animal
// и имеющие публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).
//        •	•
//В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не поддерживающий интерфейс Animal
// или не имеющий публичного конструктора без параметров (среди классов расположенных в директории переданной в качестве параметра).
//        •	•
//Метод getAllAnimals должен быть статическим.


/*
ClassLoader - что это такое? ВОТ ЧТО РЕДЛАГАЕТ JAVARUSH какая та дичь
*/
//
//public class Solution {
//    public static void main(String[] args) {
//        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
//        System.out.println(allAnimals);
//    }
//
//    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
//        Set<Animal> result = new HashSet<>();
//        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
//            pathToAnimals = pathToAnimals + "/";
//        File dir = new File(pathToAnimals);
//        String[] pathes = dir.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir1, String name) {
//                return name.toLowerCase().endsWith(".class");
//            }
//        });
//        for (String p : pathes) {
//            try {
//                final String finalPathToAnimals = pathToAnimals;
//                boolean hasInterface = false;
//                boolean hasConstructor = false;
//
//                ClassLoader loader = new ClassLoader() {
//                    @Override
//                    public Class<?> findClass(String className) throws ClassNotFoundException {
//                        try {
//                            byte[] b = fetchClassFromFS(finalPathToAnimals + className + ".class");
//                            return defineClass(null, b, 0, b.length);
//                        } catch (FileNotFoundException ex) {
//                            return super.findClass(className);
//                        } catch (IOException ex) {
//                            return super.findClass(className);
//                        }
//                    }
//                };
//                String className = p.substring(0, p.length() - 6);
//                Class clazz = loader.loadClass(className);
//
//                Class[] interfaces = clazz.getInterfaces();
//                for (Class i : interfaces) {
//                    if (Animal.class == i) {
//                        hasInterface = true;
//                        break;
//                    }
//                }
//                if (!hasInterface) continue;
//
//                Constructor[] constructors = clazz.getConstructors();
//                for (Constructor c : constructors) {
//                    if (c.getParameterTypes().length == 0) {
//                        hasConstructor = true;
//                        break;
//                    }
//                }
//                if (!hasConstructor) continue;
//                result.add((Animal) clazz.newInstance());
//            } catch (Exception e) {
//            }
//        }
//        return result;
//    }
//
//
//    private static byte[] fetchClassFromFS(String path) throws IOException {
//        InputStream is = new FileInputStream(new File(path));
//        // Get the size of the file
//        long length = new File(path).length();
//        if (length > Integer.MAX_VALUE) {
//            // File is too large
//        }
//        // Create the byte array to hold the data
//        byte[] bytes = new byte[(int) length];
//        // Read in the bytes
//        int offset = 0;
//        int numRead = 0;
//        while (offset < bytes.length
//                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
//            offset += numRead;
//        }
//        // Ensure all the bytes have been read in
//        if (offset < bytes.length) {
//            throw new IOException("Could not completely read file " + path);
//        }
//        // Close the input stream and return bytes
//        is.close();
//        return bytes;
//    }
//}

