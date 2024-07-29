package uz.com.demorender.model;


import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
@Getter
public class MyOrderProducts {

    private final Set<Integer> myOrderProducts=new HashSet<>();
}
