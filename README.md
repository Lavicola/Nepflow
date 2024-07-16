# Nepflow

## Introduction
Nepenthes are carnivorous plants that have found a steadily growing following in recent years, although some species can reach prices of over €100. There are numerous sources for information and pictures of different species.

[Tom's Carnivores](https://tomscarnivores.com/resources/nepenthes-interactive-guide/) offers a function to determine the climatic requirements of different species. [Marcellocatalano](https://www.marcellocatalano.com/aaa.htm) provides a code database that lists the different clones of Borneo Exotics. [Cpphotofinder](https://cpphotofinder.com/Nepenthes.html)
presents an extensive picture gallery that allows you to view pictures of different species and hybrids.
The GFP (Society for Carnivorous Plants) maintains a special [subforum](https://forum.carnivoren.org/forums/forum/132-pollen/)
in their forum, which is used to find crossing partners for Nepenthes. In addition to GFP, there are various [groups](https://www.facebook.com/groups/1615538418599583?_rdr) on Facebook dedicated to the exchange of pollen providers and seekers.

## Motivation
In addition to the wealth of websites offering special features for Nepenthes and the ever-growing number of stores stocking these plants, the increasing variety of hybrid plants being bred underlines the fact that this hobby is in a golden age. However, one problem that currently arises from the many crosses and hybrids is that over time it becomes increasingly difficult to trace the lineage of one's own plant. Nepflow aims to help tackle this challenge using the following steps:
1. At first Nepflow introduce a NepenthesManagagement Component which will allow to create Clones of specific Nepenthes (mostly done)
2. It will then introduce a UserManagement. (done)
3. Using the UserManagement and the NepenthesManagement functionallity will be introduced which will enable an User to build his own Growlist (mostly done) and mark plants as "flowering"
4. On Top of the GrowlistManagement, a PollenExchange Component which will use the "flowering" event in Order to create Pollenoffers.
5. TODO 

## Key Tasks and Questions Nepflow aims to answer
While the Main Focus in on the Pollen Exchange, Nepflow and the underlying Datamodel aims to answer the following questions (the list is not exhaustive):
1. what is the family tree of a Nepenthes
2.  How often does a particular Nepenthes flower on a particular person?
3. which Nepenthes are crossed particularly frequently?
4. what is the crossing success rate of a user?
5. are there Nepenthes that are sterile or rarely bear seeds?
6. which clone of a Nepenthes is particularly popular

## Current Technology Stack
- Java Spring Boot
- Angular 
- OpenAPI
- Neo4j
- MinIo
- GitHubActions

## Wireframes Frontend
For a rough overview of the different pages, see [Wireframes](https://app.moqups.com/Fi0hP5DnuFjdzxUPjcqYW32ByDKFwJDz/view/page/ae3f4a291), which are updated/improved/extended at irregular intervals.

## Current Datamodel(Overview)
Most of the Datamodel is now developed and looks currently like this (only in ligh mode good visible):
![First Draft](https://raw.githubusercontent.com/Lavicola/Nepflow/master/db_schemaFull.svg)
If the Datamodel is broken down into the most important parts it would look like this:
![First Draft](https://raw.githubusercontent.com/Lavicola/Nepflow/master/db_schemaBrokendown.svg)

### Species, Clone, User and Nepenthes
- A species is a specific Nepenthes such as "villosa".
- A species has a Clone which can either be "seedgrown", but also clones which are propagted in an a Laboratory(Producer) with a specific code (e.g. BE-3225)
- A user grows specific Nepenthes, which can either represent a specific clone (once again either "seedgrown" or "propagted")
&rarr; A missing "Producer" Edge means the Clone must be Seedgrown  
&rarr; Through the "Species" node it is later possible to find out how many different, unique clones, but also seedgrown specimens exist for them  
&rarr; A User grows "Nepenthes". Via traversing the "Clone" and the "Species" can be found. This prevents super Nodes in Clones and also enables a clearer Datamodel.

### FlowerOffer
Since the goal is to combine a PollenExchange with a familytree for Nepenthes a User must be able to "publish" a new "FlowerOffer". This FlowerOffer contains relationships to the User and the flowering Nepenthes he offers.  
&rarr; Using the "flowers" relationship to a "FlowerOffer", the Question "how often did a specific Nepenthes bloom" answered, but also more general Questions.


### Datamodel(Species)
While the first Datamodel gives an Overview, it is missing the functinality for the PollenExchange. Therefore the following Datamodel shows an Example on how the Datamodel looks like after a Trade(PollenExchange), if two
Users have the same Species.  
![First Draft](https://github.com/Lavicola/Nepflow/blob/master/DatamodelSpecies.png)
The Datamodel shows two different Clones of the same species. A User with an open FlowerOffer is able to initiate a Trade where he offers a specific FlowerOffer. For the start relationship the other Party has a "pending". Using this Information the User can then either "accept" or "refuse" the trade. If the Edge is "accepted" both Parties can confirm a new "Grex" once they received their seeds.
&rarr; Using this Datamodel it is possible to prevent User creating duplicate Trades  
&rarr; Using the "initiate" edge we can track the amount of Trades a specific User initiated.  
&rarr; Using the "results_in" edge we can detect how many Trade actually resulted in a new Grex, which means we are able to track the amount of failures e.g. User did not send seed back or seeds were faulty.  
&rarr; Using this Datamodel the offspring results in a new clone Node with a relation to the Species


### Class Diagram Clones
(TODO update Class Diagram)
In the Domain "Nepenthes" there are several different types of Clones we must introduce in order to get a full Picture of the Domain:
- A Clone itself is an abstract Type since it is missing the context.
- A "hybrid" consists of at two different types of "SpeciesClones".
- A "Multi-Hybrid" consists of at least three different species which also includes F2 hybrids e.g (villosa x hamata) x villosa
- Both "hybrid" and "Multi-Hybrid" contain a mother and father part as property
- A IVClone and a ICClone only differs in the fact that a IVClone is propagated in a laboratory (therefore has a Producer)
&rarr; Using a Graphdatabase allows us to restrict the Search space using labels
![Clones](https://github.com/Lavicola/Nepflow/blob/master/ClassDiagramClones.png)


### Rough Overview of Components
![components](https://github.com/Lavicola/Nepflow/blob/master/MainComponents.png)
I am Fan of modularity and therefore I always try to realize this.
In Nepflow I am thinking roughly of four different Components:
- UserManagement
- NepenthesManagement, which is used in order to add new Clones/Nepenthes to the Application
- GrowListManagement, which realized the functionallity to add different types of Clones to a specific User and therefore needs to access information of both Components
- PollenExhcnange, which will realize the functionallity for Trades. This Components needs to access GrowlistManagement and UserManagement.

### Example of GrowlistManagement as a Graph
![components](https://github.com/Lavicola/Nepflow/blob/master/exampleGrowlist.PNG)
The yellow Nodes represent an instance of a specific Clone.
