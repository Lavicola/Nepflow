package com.nepflow.NepenthesManagement.Model;

abstract class MultiHybrid extends AbstractHybrid{


    public MultiHybrid(){

    }

    public MultiHybrid(String name, Grex grex,Sex sex) {
        super(name, grex);
        this.sex = sex;
    }

    protected void setParents() {
        int braceCount = 0;
        String mother = "";
        String father = "";

        if (name.charAt(0) == '(') {
            for (int i = 0; i <= name.length(); i++) {
                if ('(' == name.charAt(i)) {
                    braceCount++;
                } else if (')' == name.charAt(i)) {
                    braceCount--;
                    if (braceCount == 0) {
                        // the first bracket belongs to the whole
                        mother = name.substring(1, i);
                        father = name.substring(i + 4);
                        break;
                    }
                }
            }
        } else {
            for (int i = name.length() - 1; i >= 0; i--) {
                char c = name.charAt(i);
                if (c == ')') {
                    braceCount++;
                } else if (c == '(') {
                    braceCount--;
                    if (braceCount == 0) {
                        father = name.substring(i+1);
                        mother = name.substring(0, i - 3);
                        break;
                    }
                }
            }
        }
        this.motherName = mother;
        this.fatherName = father;

    }



    protected boolean checkPreCondition(String name){
        return isValidFormat(name);
    }


    @Override
    protected  boolean isValidFormat(String input) {
        String temp = "";
        // substitutionCount must be increased at least 4 times (3 iterations are always guranteed9
        int substitionCount = -4;
        while (!temp.equals(input)) {
            temp = input;
            // ((NAME x NAME) x NAME) = (NAME x NAME)
            input = input.replaceAll("\\(\\(\\w+ x \\w+\\) x \\w+\\)", "(N x N)");
            substitionCount++;
        }
        temp = "";
        while (!temp.equals(input)) {
            temp = input;
            // (NAME x NAME) = NAME
            input = input.replaceAll("\\(\\w+ x \\w+\\)", "N");
            substitionCount++;

        }
        temp = "";
        while (!temp.equals(input)) {
            temp = input;
            // NAME x NAME = ""
            input = input.replaceAll("\\w+ x \\w+", "");
            substitionCount++;
        }
        return input.equals("") && substitionCount > 0;
    }

    public AbstractHybrid createHybrid(String name, String cloneId, Grex grex, Producer producer){
        if(producer == null){
            return new ICMultiHybrid(name, grex,sex);
        }else{
            return new IVMultiHybrid(name, cloneId, grex,sex,producer);
        }
    }

    public AbstractHybrid createConcreteIVHybrid(String name, String cloneId, Grex grex, Producer producer) {
        return new IVMultiHybrid(name, cloneId, grex,sex, producer);
    }

    public AbstractHybrid createConcreteICHybrid(String name, Grex grex,Sex sex) {
        return new ICMultiHybrid(name, grex,sex);
    }



    @Override
    void checkPostCondition() {
        // Check if every species in the hybrid exists
        // Check if grex parents fulfil the condition to be called MultiHybrid

      //  assert Clone.validPlants.contains(this.motherName) : String.format("Mother Nepenthes (%s) does not exist", this.motherName);
      //  assert Clone.validPlants.contains(this.fatherName) : String.format("Father Nepenthes (%s) does not exist", this.fatherName);

        if(grex == null){
            return;
        }
        assert (grex.father != null) : "Father of Grex is not allowed to be null";
        assert (grex.mother != null) : "Mother of Grex is not allowed to be null";
        assert (grex.father instanceof ICMultiHybrid || grex.father instanceof ICHybrid || grex.father instanceof SpeciesClone) :
                "Father must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (grex.mother instanceof ICMultiHybrid || grex.mother instanceof ICHybrid || grex.mother instanceof SpeciesClone) :
                "Mother must be an instance of Multihybrid, Hybrid or SpeciesClone";
        assert (!(grex.mother instanceof SpeciesClone && grex.father instanceof SpeciesClone)) :
                "Both parents are not allowed to be species";
        //Since certain clones are actually a pool of clones it is better to allow it, otherwise it is getting too complex for Users
        //assert (!father.equals(mother)): "Father and Mother cant be the same Hybrid";


    }

}
