package br.com.pokegraph.service;

import br.com.pokegraph.dto.AreaDTO;
import br.com.pokegraph.dto.PokemonDTO;
import br.com.pokegraph.exception.EmptyListPokemonException;
import br.com.pokegraph.model.Area;
import br.com.pokegraph.model.Pokemon;
import br.com.pokegraph.repository.AreaRepository;
import br.com.pokegraph.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AreaService {
    private final AreaRepository areaRepository;
    private final PokemonRepository pokemonRepository;

    public AreaService(AreaRepository areaRepository, PokemonRepository pokemonRepository) {
        this.areaRepository = areaRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public List<AreaDTO> findAll() {
        List<AreaDTO> areaDTOList = new ArrayList<>();
        List<Area> areaList = areaRepository.findAll();
        areaList.forEach(area -> areaDTOList.add(new AreaDTO(area)));
        if (areaDTOList.isEmpty()) {
            throw new EmptyListPokemonException("Não existe pokêmon's cadastrados!");
        }
        return areaDTOList;
    }

    public List<Long> findAllByPokemon(Long id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow();

        List<Area> allAreas = areaRepository.findAll();

        List<Long> pokemonAreas = new ArrayList<>();

        allAreas.forEach(area->{
            if(area.getPokemons().contains(pokemon.getName().toLowerCase())){
                pokemonAreas.add(area.getId());
            }
        });

        return pokemonAreas;
    }

    public AreaNode findClosestArea(Long idPokemon, Long idArea){

        //ids de areas onde o pokemon selecionado se encontra
        List<Long> pokemonAreas= findAllByPokemon(idPokemon);

        //iniciar grafo
        MapGraph grafo = initAreaGraph();

        //pegar o nó que irá iniciar a percurso
        List<AreaNode> initialNode = grafo.getAreaNodes().stream().filter(a -> a.getId().equals(idArea)).collect(Collectors.toList());

        //aplicação do dijkstra
        calculateShortestPathFromSource(grafo, initialNode.get(0));

        //iniciar o iterator para percorrer o grafo
        Iterator<AreaNode> nodeIterator = grafo.getAreaNodes().iterator();

        //iniciar node inicial, com distância maior que a possivel(será substituído pelo primeiro)
        AreaNode closestNode = new AreaNode(100L);
        closestNode.setDistance(1000);

        while (nodeIterator.hasNext()){
            AreaNode next = nodeIterator.next();
            if (pokemonAreas.contains(next.getId())){
                if(closestNode.getDistance() > next.getDistance()){
                    closestNode = next;
                }
            }
        }

        return closestNode;
    }

    public MapGraph initAreaGraph(){
        AreaNode node1 = new AreaNode(1L);
        AreaNode node2 = new AreaNode(2L);
        AreaNode node3 = new AreaNode(3L);
        AreaNode node4 = new AreaNode(4L);
        AreaNode node5 = new AreaNode(5L);
        AreaNode node6 = new AreaNode(6L);
        AreaNode node7 = new AreaNode(7L);
        AreaNode node8 = new AreaNode(8L);
        AreaNode node9 = new AreaNode(9L);
        AreaNode node10 = new AreaNode(10L);
        AreaNode node11 = new AreaNode(11L);
        AreaNode node12 = new AreaNode(12L);
        AreaNode node13 = new AreaNode(13L);
        AreaNode node14 = new AreaNode(14L);
        AreaNode node15 = new AreaNode(15L);
        AreaNode node16 = new AreaNode(16L);
        AreaNode node17 = new AreaNode(17L);
        AreaNode node18 = new AreaNode(18L);
        AreaNode node19 = new AreaNode(19L);
        AreaNode node20 = new AreaNode(20L);
        AreaNode node21 = new AreaNode(21L);
        AreaNode node22 = new AreaNode(22L);
        AreaNode node23 = new AreaNode(23L);
        AreaNode node24 = new AreaNode(24L);
        AreaNode node25 = new AreaNode(25L);
        AreaNode node26 = new AreaNode(26L);
        AreaNode node27 = new AreaNode(27L);
        AreaNode node28 = new AreaNode(28L);
        AreaNode node29 = new AreaNode(29L);
        AreaNode node30 = new AreaNode(30L);
        AreaNode node31 = new AreaNode(31L);
        AreaNode node32 = new AreaNode(32L);
        AreaNode node33 = new AreaNode(33L);
        AreaNode node34 = new AreaNode(34L);
        AreaNode node35 = new AreaNode(35L);
        AreaNode node36 = new AreaNode(36L);
        AreaNode node37 = new AreaNode(37L);
        AreaNode node38 = new AreaNode(38L);
        AreaNode node39 = new AreaNode(39L);
        AreaNode node40 = new AreaNode(40L);
        AreaNode node41 = new AreaNode(41L);
        AreaNode node42 = new AreaNode(42L);
        AreaNode node43 = new AreaNode(43L);
        AreaNode node44 = new AreaNode(44L);
        AreaNode node45 = new AreaNode(45L);
        AreaNode node46 = new AreaNode(46L);
        AreaNode node47 = new AreaNode(47L);

        node1.addDestination(node2, 1);
        node1.addDestination(node40, 5);

        node2.addDestination(node1, 1);
        node2.addDestination(node3, 2);

        node3.addDestination(node41, 5);
        node3.addDestination(node2, 2);
        node3.addDestination(node4, 2);

        node4.addDestination(node6, 1);
        node4.addDestination(node3, 2);
        node4.addDestination(node5, 2);

        node5.addDestination(node47, 1);
        node5.addDestination(node4, 2);

        node6.addDestination(node4, 1);
        node6.addDestination(node25, 1);
        node6.addDestination(node16, 1);

        node7.addDestination(node47, 3);
        node7.addDestination(node8, 1);

        node8.addDestination(node7, 1);
        node8.addDestination(node9, 5);

        node9.addDestination(node8, 5);
        node9.addDestination(node11, 5);

        node10.addDestination(node11, 6);

        node11.addDestination(node10, 6);
        node11.addDestination(node9, 5);
        node11.addDestination(node44, 5);
        node11.addDestination(node24, 7);
        node11.addDestination(node12, 1);

        node12.addDestination(node11, 1);
        node12.addDestination(node13, 1);

        node13.addDestination(node12, 1);
        node13.addDestination(node14, 1);
        node13.addDestination(node17, 1);
        node13.addDestination(node15, 5);
        node13.addDestination(node19, 2);

        node14.addDestination(node13, 1);

        node15.addDestination(node13, 5);
        node15.addDestination(node16, 5);

        node16.addDestination(node15, 5);
        node16.addDestination(node6, 1);

        node17.addDestination(node13, 1);
        node17.addDestination(node18, 1);

        node18.addDestination(node17, 1);
        node18.addDestination(node32, 3);

        node19.addDestination(node13, 2);
        node19.addDestination(node46, 2);

        node20.addDestination(node46, 1);

        node21.addDestination(node46, 7);
        node21.addDestination(node24, 7);

        node22.addDestination(node24, 3);

        node23.addDestination(node24, 5);

        node24.addDestination(node21, 7);
        node24.addDestination(node22, 3);
        node24.addDestination(node23, 5);

        node25.addDestination(node6, 1);
        node25.addDestination(node26, 1);

        node26.addDestination(node46, 7);
        node26.addDestination(node25, 1);
        node26.addDestination(node27, 7);

        node27.addDestination(node26, 7);
        node27.addDestination(node28, 7);

        node28.addDestination(node27, 7);
        node28.addDestination(node29, 2);

        node29.addDestination(node28, 2);
        node29.addDestination(node31, 2);

        node30.addDestination(node31, 1);

        node31.addDestination(node29, 2);
        node31.addDestination(node30, 1);
        node31.addDestination(node35, 8);
        node31.addDestination(node34, 2);

        node32.addDestination(node18, 3);
        node32.addDestination(node33, 3);

        node33.addDestination(node32, 3);
        node33.addDestination(node34, 2);

        node34.addDestination(node31, 2);
        node34.addDestination(node33, 2);

        node35.addDestination(node31, 8);
        node35.addDestination(node36, 8);

        node36.addDestination(node35, 8);
        node36.addDestination(node37, 5);

        node37.addDestination(node36, 5);
        node37.addDestination(node38, 5);

        node38.addDestination(node37, 5);
        node38.addDestination(node40, 5);
        node38.addDestination(node39, 1);

        node39.addDestination(node38, 1);

        node40.addDestination(node38, 5);
        node40.addDestination(node1, 5);

        node41.addDestination(node3, 5);
        node41.addDestination(node42, 5);

        node42.addDestination(node41, 5);
        node42.addDestination(node43, 6);

        node43.addDestination(node42, 6);

        node44.addDestination(node11, 5);
        node44.addDestination(node45, 1);

        node45.addDestination(node44, 1);

        node46.addDestination(node20, 1);
        node46.addDestination(node26, 7);
        node46.addDestination(node19, 2);
        node46.addDestination(node21, 7);

        node47.addDestination(node7, 3);
        node47.addDestination(node5, 1);


        MapGraph graph = new MapGraph();

        graph.addAreaNode(node1);
        graph.addAreaNode(node2);
        graph.addAreaNode(node3);
        graph.addAreaNode(node4);
        graph.addAreaNode(node5);
        graph.addAreaNode(node6);
        graph.addAreaNode(node7);
        graph.addAreaNode(node8);
        graph.addAreaNode(node9);
        graph.addAreaNode(node10);
        graph.addAreaNode(node11);
        graph.addAreaNode(node12);
        graph.addAreaNode(node13);
        graph.addAreaNode(node14);
        graph.addAreaNode(node15);
        graph.addAreaNode(node16);
        graph.addAreaNode(node17);
        graph.addAreaNode(node18);
        graph.addAreaNode(node19);
        graph.addAreaNode(node20);
        graph.addAreaNode(node21);
        graph.addAreaNode(node22);
        graph.addAreaNode(node23);
        graph.addAreaNode(node24);
        graph.addAreaNode(node25);
        graph.addAreaNode(node26);
        graph.addAreaNode(node27);
        graph.addAreaNode(node28);
        graph.addAreaNode(node29);
        graph.addAreaNode(node30);
        graph.addAreaNode(node31);
        graph.addAreaNode(node32);
        graph.addAreaNode(node33);
        graph.addAreaNode(node34);
        graph.addAreaNode(node35);
        graph.addAreaNode(node36);
        graph.addAreaNode(node37);
        graph.addAreaNode(node38);
        graph.addAreaNode(node39);
        graph.addAreaNode(node40);
        graph.addAreaNode(node41);
        graph.addAreaNode(node42);
        graph.addAreaNode(node43);
        graph.addAreaNode(node44);
        graph.addAreaNode(node45);
        graph.addAreaNode(node46);
        graph.addAreaNode(node47);


        return graph;
    }

    public static class MapGraph {

        private Set<AreaNode> nodes = new HashSet<>();

        public void addAreaNode(AreaNode nodeA) {
            nodes.add(nodeA);
        }

        public Set<AreaNode> getAreaNodes() {
            return nodes;
        }

        public void setAreaNodes(Set<AreaNode> nodes) {
            this.nodes = nodes;
        }
    }

    public static class AreaNode {

        private  Long id;

        private  List<AreaNode> shortestPath = new LinkedList<>();

        private  Integer distance = Integer.MAX_VALUE;

        Map<AreaNode, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(AreaNode destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public AreaNode(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<AreaNode> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<AreaNode> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Map<AreaNode, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<AreaNode, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }
    }

    private static AreaNode getLowestDistanceNode(Set < AreaNode > unsettledNodes) {
        AreaNode lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (AreaNode node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(AreaNode evaluationNode,
                                                 Integer edgeWeigh, AreaNode sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<AreaNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static MapGraph calculateShortestPathFromSource(MapGraph graph, AreaNode source) {
        source.setDistance(0);

        Set<AreaNode> settledNodes = new HashSet<>();
        Set<AreaNode> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            AreaNode currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< AreaNode, Integer> adjacencyPair:
                currentNode.getAdjacentNodes().entrySet()) {
                AreaNode adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

//    private static AreaNode getClosest(Long id) {
//    }

}
