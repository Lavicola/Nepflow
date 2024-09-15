# Nepflow

## Introduction
Nepenthes are carnivorous plants that have found a steadily growing following in recent years, although some species can reach prices of over €100. There are numerous sources for information and pictures of different species.

[Tom's Carnivores](https://tomscarnivores.com/resources/nepenthes-interactive-guide/) offers a function to determine the climatic requirements of different species. [Marcellocatalano](https://www.marcellocatalano.com/aaa.htm) provides a code database that lists the different clones of Borneo Exotics. [Cpphotofinder](https://cpphotofinder.com/Nepenthes.html)
presents an extensive picture gallery that allows you to view pictures of different species and hybrids.
The GFP (Society for Carnivorous Plants) maintains a special [subforum](https://forum.carnivoren.org/forums/forum/132-pollen/)
in their forum, which is used to find crossing partners for Nepenthes. In addition to GFP, there are various [groups](https://www.facebook.com/groups/1615538418599583?_rdr) on Facebook dedicated to the exchange of pollen providers and seekers.

## Current State
Click on the image below to view a YouTube video showcasing the current state of the project. While the design of the video may not be the primary focus, the emphasis is on demonstrating the functionality and progress of the project.
<a href="https://www.youtube.com/watch?v=wQUNHZGiVh8"><img src="https://nepflow.de/wp-content/uploads/2024/09/thumbnail.png" alt="Press to see video" style="width:800px;height:350px;"></a> <br>
the video shows the following functionalities:
- Custom Angular Material 3 Theme
- Account creation via an external identity management system (passwords are never stored by me and neither are email addresses at present)
- Fill in a user name and contact information as well as the country (these are then stored in my application)
- Adding a plant
- Viewing the growlist and making changes to a plant
- Viewing all current pollen offers, filtering and sending a request for pollen/flowering
- Viewing the trades for which the user is still waiting for a response
(Switching the browser to a new user and opening a new pollen offer) 
- Sending another request for the newly created pollen offer
(switching the browser to a new user and answering the request)
- Show the completed trades and the dark mode
- Opening a private growlist
- Switching the browser to a new user and viewing the statistics (Each bar shows a specific plant, as you can have several specimens of one species)



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

### Label, Clone, Specimen and User
- A Label(Species/Primary Hybrid) is a specific Nepenthes such as "villosa".
- A Label has Clones which can be "seedgrown" or "IV" (propagted in an a Laboratory with a specific code e.g. BE-3225)
- A user grows specific "Specimens", which can either represent a specific clone (once again either "seedgrown" or "IV")

&rarr; Through the "Label" node it is later possible to find out how many different, unique clones, but also seedgrown specimens exist.  
&rarr; A User grows "Specimens". Via traversing (Specimen --> Clone --> Label) the information can be retrieved. 

### PollenOffer
Since the goal is to combine a PollenExchange with a familytree for Nepenthes a User must be able to "publish" a new "PollenOffer". This PollenOffer contains relationships to the User and the flowering Nepenthes (more concrete to a specific Specimen).  

&rarr; Using the amount of "PollenOffer" Nodes for a specific Specimen the Question "How often did the Specimen flower" can be answered using  
&rarr; with a specific relationship (HAS_FLOWERED and FLOWERED) the current and old PollenOffer can be quickly found (specimen-[HAS_FLOWERED|FLOWERED]   


### Datamodel(Label/Species)
While the first Datamodel gives an Overview, it is missing the functinality for the PollenExchange. Therefore the following Datamodel shows an Example on how the Datamodel looks like after a Trade, if two
Users have the same Species.  
![First Draft](https://github.com/Lavicola/Nepflow/blob/master/DatamodelSpecies.png)
The Datamodel shows two different Clones of the same species. A User with an open FlowerOffer is able to initiate a Trade where he offers a specific FlowerOffer. For the start relationship the other Party has a "pending". Using this Information the User can then either "accept" or "refuse" the trade. If the Edge is "accepted" both Parties can confirm a new "Grex" once they received their seeds.
&rarr; Using Nodes User <--Trade --> PollenOffer it is possible to detect/prevent duplicate Trades 
&rarr; Using the "initiate" edge we can track the amount of Trades a specific User initiated.  
&rarr; Using the "results_in" edge we can detect how many Trade actually resulted in a new Grex, which means we are able to track the amount of failures e.g. User did not send seed back or seeds were faulty.  
&rarr; Using this Datamodel the offspring results in a new clone Node with a relation to the Species and Grex   ( Grex --> Clone --> Label) 


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
- NepenthesManagement, which is used(provides functionality) in order to add new Clones/Labels to the Application
- GrowlistManagement, which realizes the functionallity to add different types of Clones to a specific User and therefore needs to access information of both Components (UserManagement and NepenthesManagement)
- PollenExhcnange, which will realize the functionallity for Trades. This Components needs to access GrowlistManagement and UserManagement.
- later: ChatComponent: Will use Ids of Trades and Users in order to provide a Chat for every accepted Trade (since it only needs Ids and no real knowledge of Models I will realize it in the future as a small microservice with a document store e.g. MongoDB

### Example of GrowlistManagement as a Graph
![components](https://github.com/Lavicola/Nepflow/blob/master/exampleGrowlist.PNG)
The yellow Nodes represent an instance(specimen) of a specific Clone.
