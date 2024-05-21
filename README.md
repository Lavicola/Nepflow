# Nepflow

## Introduction
Nepenthes are carnivorous plants that have found a steadily growing following in recent years, although some species can reach prices of over €100. There are numerous sources for information and pictures of different species.

[Tom's Carnivores](https://tomscarnivores.com/resources/nepenthes-interactive-guide/) offers a function to determine the climatic requirements of different species. [Marcellocatalano](https://www.marcellocatalano.com/aaa.htm)provides a code database that lists the different cloning variants of Borneo Exotics. [Cpphotofinder](https://cpphotofinder.com/Nepenthes.html)
presents an extensive picture gallery that allows you to view pictures of different species and hybrids.
The GFP (Society for Carnivorous Plants) maintains a special [subforum](https://forum.carnivoren.org/forums/forum/132-pollen/)
in their forum, which is used to find crossing partners for Nepenthes. In addition to GFP, there are various [groups](https://www.facebook.com/groups/1615538418599583?_rdr) on Facebook dedicated to the exchange of pollen providers and seekers.

## Motivation
In addition to the wealth of websites offering special features for Nepenthes and the ever-growing number of stores stocking these plants, the increasing variety of hybrid plants being bred underlines the fact that this hobby is in a golden age. However, one problem that currently arises from the many crosses and hybrids is that over time it becomes increasingly difficult to trace the lineage of one's own plant. Nepflow aims to help tackle this challenge. As a first step, Nepflow will function as a kind of pollen exchange platform. Users can register on the website and add their Nepenthes. On the basis of filterable attributes such as "flowering" or "soon to flower", it will then be possible to offer pollen (male) or flowers (female) of a Nepenthes in order to create a pollen exchange platform. Based on this idea, users are also given the opportunity to reference or add the parents of their plants, if known. By referencing, collecting and storing this information, users will be able to view the family tree of their own plants in the future.

## Key Tasks and Questions Nepflow aims to answer
While the Main Focus in on the Pollen Exchange, Nepflow and the underlying data model aims to answer the following questions (the list is not exhaustive):
1. what is the family tree of a Nepenthes?
2. How often does a particular Nepenthes of an User flower?
3. which Nepenthes are crossed particularly frequently?
4. what is the crossing success rate of an user?
5. are there Nepenthes that are sterile or rarely bear seeds?
6. which clone of a Nepenthes is particularly popular
7. How many different Species, Hybrids and Multihybrids exist

## Current Technology Stack
- Java Spring Boot
- Angular 
- OpenAPI
- Neo4j 
- Auth0

## Wireframes Frontend
For a rough overview of the different pages, see [Wireframes](https://app.moqups.com/Fi0hP5DnuFjdzxUPjcqYW32ByDKFwJDz/view/page/ae3f4a291), which are updated/improved/extended at irregular intervals.

## Current data model(Nepenthesmanagement and GrowlistManagement)
After several rounds of refactoring, Nepflow has adopted the following underlying data model to store and manage Seedgrown (IC) and IV species (Nepenthes), hybrids, and other types such as multihybrids. Furthermore, the data model enables users to add various types of Nepenthes to their accounts, ensuring a comprehensive and organized approach to tracking and managing their collection.
![Draft](https://github.com/Lavicola/Nepflow/blob/master/data modelOverviewNepGrow.png)

The instance data model could look like this then:
![Instance](https://github.com/Lavicola/Nepflow/blob/master/Instancedata model.png)

### Label, Clone, User and Specimen
- A Label is an abstract type and simply defines the necessary property and relationships
  - Nepenthes is a subclass of Label and represents species e.g villosa
  - HybridLabel is an abstract subclass of Label and extends the functionality
    - Hybrid is a subclass of HybridLabel and represents a cross between two species
- A Clone (for seedgrown) is an abstract type and simply defines the necessary property and relationships for Clones
![Classdiagram](https://github.com/Lavicola/Nepflow/blob/master/LabelHierarchy.png)




### PollenExchange
Since the goal is to combine a PollenExchange with Management of Nepenthes while slowly building a familytree the data model must be extended:
![Draft](https://github.com/Lavicola/Nepflow/blob/master/DatamodelSpecies.png)
As the data model shows, a Clone may reference a Grex in order to slowly build up the familytree of a Specimen.



### Class Diagram Clones
In the Domain "Nepenthes" there are several different types of Clones we must introduce in order to get a full Picture of the Domain:
- A Clone itself is an abstract Type since it is missing the context.
- A IVClone is also an abstract type, but extends the Clone of some classmembers and relationships
- A "hybrid" consists of exactly two different types of Species(Nepenthes). 
- A "Multi-Hybrid" consists of at least three different species which also includes F2 hybrids for now e.g (villosa x hamata) x villosa
- Both "hybrid" and "Multi-Hybrid" contain a mother and father part as property
&rarr; Since often IV Clones are a Pool of several specimen the internalCloneid was added to provide an unique ID which consists of the cloneId itself AND the first letter of the Sex. This way we can have a three identically Nodes at max (e.g BE-3552(Unkown sex),BE-3552-F(Female),BE-3552-M(Male)) where an User can reference the right one.
&rarr; The presented Hierarchy allows to efficiently reduce the subgraph using the different types of clonelabels
![Clones](https://github.com/Lavicola/Nepflow/blob/master/ClassDiagramClones.png)


### Rough Overview of Components
![components](https://github.com/Lavicola/Nepflow/blob/master/MainComponents.png)
I am Fan of modularity and therefore I always try to realize this.
In Nepflow I am thinking roughly of four different Components:
- UserManagement
- NepenthesManagement, which is used in order to add new Clones/Nepenthes to the Application
- GrowListManagement, which realized the functionality to add different types of Clones to a specific User and therefore needs to access information of both Components
- PollenExhcnange, which will realize the functionality for Trades. This Components needs to access GrowlistManagement and UserManagement.
&rarr; in the distant future I would also like to add a chat module in order to give a platform for the communication.
### Example of GrowlistManagement as a Graph
![components](https://github.com/Lavicola/Nepflow/blob/master/exampleGrowlist.PNG)
The yellow Nodes represent the Specimen.






