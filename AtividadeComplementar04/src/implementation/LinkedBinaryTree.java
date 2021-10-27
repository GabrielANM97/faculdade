package implementation;

import java.util.Iterator;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;
import interfaces.BTPosition;
import interfaces.BinaryTree;
import interfaces.Position;
import interfaces.PositionList;


public class LinkedBinaryTree<E> implements BinaryTree<E> {

	protected BTPosition<E> root; // referência para a raiz
	
	protected int size; // número de nodos
	
	// Cria uma árvore binária vazia.
	
	public LinkedBinaryTree() {
	
	root = null; // inicia com uma árvore vazia
	
	size = 0;
	
	}
	
	// Retorna o número de nodos da árvore.
	
	public int size() { return size; }
	
	// Retorna se um nodo é interno.
	
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
	
	checkPosition(v); // método auxiliar
	
	return (hasLeft(v) || hasRight(v));
	
	}
	
	// Retorna se um nodo é a raiz.
	
	public boolean isRoot(Position<E> v) throws EmptyTreeException, InvalidPositionException {
	
	checkPosition(v);
	
	return (v == root());
	
	}
	
	// Retorna se um nodo tem o filho da esquerda.
	
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	return (vv.getLeft() != null);
	
	}
	
	// Retorna a raiz da árvore.
	
	public BTPosition<E> root() throws EmptyTreeException {
	
		if (root == null) throw new EmptyTreeException("The tree is empty");
	
		return root;
	}
	
	// Retorna o filho da esquerda de um nodo.
	
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
	
	BTPosition<E> vv = checkPosition(v);
	
	Position<E> leftPos = (Position<E>) vv.getLeft();
	
	if (leftPos == null) throw new BoundaryViolationException("No left child");
	
	return leftPos;
	
	}
	
	// Retorna o pai de um nodo.
	
	public BTPosition<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
	
	BTPosition<E> vv = checkPosition(v);
	
	Position<E> parentPos = (Position<E>) vv.getParent();
	
	if (parentPos == null) throw new BoundaryViolationException("No parent");
	
	return (BTPosition<E>) parentPos;
	
	}
	
	
	// Retorna uma coleção iterável contendo os filhos de um nodo.
	
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
	
	PositionList<Position<E>> children = new NodePositionList<Position<E>>();
	
	if (hasLeft(v)) children.addLast(left(v));
	
	if (hasRight(v)) children.addLast(right(v));
	
	return children;
	
	}
	
	// Retorna uma coleção iterável (inorder) contendo os nodos da árvore.
	
	public Iterable<Position<E>> positionsInorder() {
	
	PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
	
	if (size != 0) inorderPositions(root(), positions); // atribui as posições usando caminhamento prefixado
	
	return positions;
	
	}
	
	// Cria uma lista que armazena os nodos da subárvore de um nodo ordenados de acordo com o caminhamento inorder da subárvore.
	
	public void inorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
	
	if (hasLeft(v)) inorderPositions(left(v), pos); // recursão sobre o filho da esquerda
	
	pos.addLast(v);
	
	if (hasRight(v)) inorderPositions(right(v), pos); // recursão sobre o filho da direita
	
	}
	
	// Retorna uma coleção iterável contendo os nodos da árvore.
	
	public Iterable<Position<E>> positions() {
	
	PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
	
	if (size != 0) preorderPositions(root(), positions); // atribui as posições usando caminhamento prefixado
	
	return positions;
	
	}
	
	// Retorna um iterador sobre os elementos armazenados nos nodos
	
	public Iterator<E> iterator() {
	
	Iterable<Position<E>> positions = positions();
	
	PositionList<E> elements = new NodePositionList<E>();
	
	for (Position<E> pos : positions) elements.addLast(pos.element());
	
	return elements.iterator(); // Um iterador sobre os elementos
	
	}
	
	// Substitui o elemento armazenado no nodo.
	
	public E replace(Position<E> v, E o) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	E temp = v.element();
	
	vv.setElement(o);
	
	return temp;
	
	}
	
	// Método de acesso adicional
	
	// Retorna o irmão de um nodo
	
	public Position<E> sibling(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
	
	BTPosition<E> vv = checkPosition(v);
	
	BTPosition<E> parentPos = vv.getParent();
	
	if (parentPos != null) {
	
	BTPosition<E> sibPos;
	
	BTPosition<E> leftPos = parentPos.getLeft();
	
	if (leftPos == vv) sibPos = parentPos.getRight();
	
	else sibPos = parentPos.getLeft();
	
	if (sibPos != null) return sibPos;
	
	}
	
	throw new BoundaryViolationException("No sibling");
	
	}
	
	// Métodos de acesso adicionais
	
	// Insere a raiz em uma árvore vazia
	
	public Position<E> addRoot(E e) throws NonEmptyTreeException {
	
	if (!isEmpty()) throw new NonEmptyTreeException("Tree already has a root");
	
	size = 1;
	
	root = createNode(e, null, null, null);
	
	return root;
	
	}
	
	// Insere o filho da esquerda em um nodo.
	
	public Position<E> insertLeft(Position<E> v, E e) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	Position<E> leftPos = (Position<E>) vv.getLeft();
	
	if (leftPos != null) throw new InvalidPositionException("Node already has a left child");
	
	BTPosition<E> ww = createNode(e, vv, null, null);
	
	vv.setLeft(ww);
	
	size++;
	
	return ww;
	
	}
	
	// Insere o filho a direita em um nodo.
	
	public Position<E> insertRight(Position<E> v, E e) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	Position<E> rightPos = (Position<E>) vv.getRight();
	
	if (rightPos != null) throw new InvalidPositionException("Node already has a right child");
	
	BTPosition<E> ww = createNode(e, vv, null, null);
	
	vv.setRight(ww);
	
	size++;
	
	return ww;
	
	}
	
	// Remove um nodo com zero ou um filho.
	
	public E remove(Position<E> v) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	BTPosition<E> leftPos = vv.getLeft();
	
	BTPosition<E> rightPos = vv.getRight();
	
	if (leftPos != null && rightPos != null) throw new InvalidPositionException("Cannot remove node with two children");
	
	BTPosition<E> ww; // o único filho de v, se houver
	
	if (leftPos != null) ww = leftPos;
	
	else if (rightPos != null) ww = rightPos;
	
	else // v é folha
	
	ww = null;
	
	if (vv == root) { // v é a raiz
	
	if (ww != null) ww.setParent(null);
	
	root = ww;
	
	} else { // v não é a raiz
	
	BTPosition<E> uu = vv.getParent();
	
	if (vv == uu.getLeft()) uu.setLeft(ww);
	
	else uu.setRight(ww);
	
	if (ww != null) ww.setParent(uu);
	
	}
	
	size--;
	
	return v.element();
	
	}
	
	// Conecta duas árvores para serem subárvores de um nodo externo.
	
	public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	if (isInternal(v)) throw new InvalidPositionException("Cannot attach from internal node");
	
	if (!T1.isEmpty()) {
	
	BTPosition<E> r1 = checkPosition(T1.root());
	
	vv.setLeft(r1);
	
	r1.setParent(vv); // T1 deve ser invalidada
	
	}
	
	if (!T2.isEmpty()) {
	
	BTPosition<E> r2 = checkPosition(T2.root());
	
	vv.setRight(r2);
	
	r2.setParent(vv); // T2 deve ser invalidada
	
	}
	
	}
	
	// Se v é um nodo de árvore binária, converte para BTPosition, caso contrário lança exceção
	
	protected BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
	
	if (v == null || !(v instanceof BTPosition)) throw new InvalidPositionException("The position is invalid");
	
	return (BTPosition<E>) v;
	
	}
	
	// Cria um novo nodo de árvore binária
	
	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
	
	return new BTNode<E>(element, parent, left, right);
	
	}
	
	// Cria uma lista que armazena os nodos da subárvore de um nodo ordenados de acordo com o
	
	// caminhamento prefixado da subárvore.
	
	protected void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
	
	pos.addLast(v);
	
	if (hasLeft(v)) preorderPositions(left(v), pos); // recursão sobre o filho da esquerda
	
	if (hasRight(v)) preorderPositions(right(v), pos); // recursão sobre o filho da direita
	
	}
	
	public boolean isEmpty() { return (size == 0); }
	
	public boolean isExternal(Position<E> v) throws InvalidPositionException { return !isInternal(v); }
	
	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
	
	BTPosition<E> vv = checkPosition(v);
	
	Position<E> rightPos = (Position<E>) vv.getRight();
	
	if (rightPos == null) throw new BoundaryViolationException("No right child");
	
	return rightPos;
	
	}
	
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
	
	BTPosition<E> vv = checkPosition(v);
	
	return (vv.getRight() != null);
	
	}
	
	public LinkedBinaryTree<Character> buildExpression(String E) {
		NodeStack<LinkedBinaryTree<Character>> S = new NodeStack<LinkedBinaryTree<Character>>();
		
		
		for (int i = 0; i < E.length(); i++) {
			LinkedBinaryTree<Character> T = new LinkedBinaryTree<Character>();


			if ((E.charAt(i) > 47 && E.charAt(i) < 58) || E.charAt(i) == 42 || E.charAt(i) == 43 || E.charAt(i) == 45 || E.charAt(i) == 47) {
				T.addRoot(E.charAt(i));
				S.push(T);		
			}
			else if (E.charAt(i) == 40) {
				continue;
			}
			else {
				LinkedBinaryTree<Character> T1 = new LinkedBinaryTree<Character>();
				LinkedBinaryTree<Character> T2 = new LinkedBinaryTree<Character>();
				
				T2 = S.pop();
				T = S.pop();
				T1 = S.pop();

				T.attach(T.root(), T1, T2);
				
				S.push(T);
				
			}
		}
		return S.pop();
	}

	
	
//	public void binaryPreorder(LinkedBinaryTree<Character>T, Position<E>v) {
//		if() {}
//		
//	}
	
	public Integer evaluateExpression(LinkedBinaryTree<Character> T, Position<Character> v) {
		Character o = v.element();
		
		if (T.hasLeft(v) && T.hasRight(v)) {
			Integer x = evaluateExpression(T, T.left(v));
			Integer y = evaluateExpression(T, T.right(v));
			
			if (o.charValue() == 43) {
				return x + y;
			}
			else if (o.charValue() == 42) {
				return x * y;
			}
			else if (o.charValue() == 45) {
				return x - y;
			}
			else {
				return x / y;
			}
		}
		return (int) o.charValue();
	}	
}
