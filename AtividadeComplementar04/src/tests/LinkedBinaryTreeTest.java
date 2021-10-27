package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import implementation.LinkedBinaryTree;
import interfaces.BTPosition;
import interfaces.Position;

public class LinkedBinaryTreeTest {

	LinkedBinaryTree<Character> btree = new LinkedBinaryTree<Character>();

//	@Test
//	void buildExpressionTest() {
//		String expression = "((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))";
//		LinkedBinaryTree<Character> btExpression = btree.buildExpression(expression);
//		
//		
//		assertFalse(btExpression.isEmpty());
//				
//		assertEquals(45, btExpression.root().element().charValue());
//		
//	}
	
	@Test
	void evaluateExpressionTest() {
		
		Position<Character> root = btree.addRoot('-');
		
		// lado esquerdo
		Position<Character> nivel11 = btree.insertLeft(root, '/');
				
		Position<Character> nivel21 = btree.insertLeft(nivel11, '*');
		
		Position<Character> nivel22 = btree.insertRight(nivel11, '+');
		
		Position<Character> nivel31 = btree.insertLeft(nivel21, '+');
		
		Position<Character> nivel32 = btree.insertRight(nivel21, '3');
		
		Position<Character> nivel41 = btree.insertLeft(nivel31, '3');
		
		Position<Character> nivel42 = btree.insertRight(nivel31, '1');
		
		Position<Character> nivel33 = btree.insertLeft(nivel22, '-');
		
		Position<Character> nivel34 = btree.insertRight(nivel22, '2');
		
		Position<Character> nivel43 = btree.insertLeft(nivel33, '9');
		
		Position<Character> nivel44 = btree.insertRight(nivel33, '5');
		
		// lado direito
		Position<Character> nivel12 = btree.insertRight(root, '+');
		
		Position<Character> nivel23 = btree.insertLeft(nivel12, '*');
		
		Position<Character> nivel24 = btree.insertRight(nivel12, '6');
		
		Position<Character> nivel35 = btree.insertLeft(nivel23, '3');
		
		Position<Character> nivel36 = btree.insertRight(nivel23, '-');
		
		Position<Character> nivel45 = btree.insertLeft(nivel36, '7');
		
		Position<Character> nivel46 = btree.insertRight(nivel36, '4');
		
//		assertEquals(45, btree.evaluateExpression(btree, btree.root()));
		
		Integer a = btree.evaluateExpression(btree, btree.root());
		
		assert(a == -113);
	}

}
