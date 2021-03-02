#include "gtest/gtest.h"
#include "Add.h"
#include "Op.h"
#include "Mult.h"
#include "Divide.h"
#include "Sub.h"
#include "Pow.h"
#include "container.hpp"
#include "vectorCont.h"
#include "listCont.h"
#include "BS.h"
#include "SS.h"
#include "container.hpp"
#include "Decorator.h"
#include "Trunc.h"
#include "Paren.h"
#include "Abs.h"
#include "Floor.h"
#include "Ceil.h"
#include "SciOp.h"
#include "SciFactory.h"
#include "DoubleFactory.h"
#include "PrecisionFactory.h"
#include "PrecisionOp.h"
#include <iostream>
#include "iterator.hpp"
#include "binary_iterator.cpp"
#include "unary_iterator.cpp"
#include "Dummy.h"
#include "visitor.hpp"
using namespace std;
/*
TEST(AddTest, Evaluate) {
        Op* first = new Op(4);
        Op* second = new Op(6);
        Add testAddition(first, second);
        EXPECT_EQ(10, testAddition.evaluate());
}

TEST(AddTest, Stringify) {
        Op* first = new Op(7);
        Op* second = new Op(8);
        Add testAddition(first, second);
        EXPECT_EQ("7 + 8", testAddition.stringify());
}

TEST(SubTest, Evaluate) {
        Op* first = new Op(10);
        Op* second = new Op(2);
        Sub testSubtraction(first, second);
        EXPECT_EQ(8, testSubtraction.evaluate());
}

TEST(SubTest, Stringify) {
        Op* first = new Op(12);
        Op* second = new Op(4);
        Sub testSubtraction(first, second);
        EXPECT_EQ("12 - 4", testSubtraction.stringify());
}

TEST(DivTest, Stringify) {
        Op* first = new Op(12);
        Op* second = new Op(6);
        Divide testDiv(first, second);
        EXPECT_EQ("12 / 6", testDiv.stringify());
}

TEST(DivTest, Evaluate) {
        Op* first = new Op(12);
        Op* second = new Op(6);
        Divide testDiv(first, second);
        EXPECT_EQ(2, testDiv.evaluate());
}
TEST(MultTest, Stringify) {
        Op* first = new Op(7);
        Op* second = new Op(8);
        Mult testMult(first, second);
        EXPECT_EQ("7 * 8", testMult.stringify());

}
TEST(MultTest, Evaluate) {
        Op* first = new Op(7);
        Op* second = new Op(8);
        Mult testMult(first, second);
        EXPECT_EQ(56, testMult.evaluate());
}

TEST(PowTest, Evaluate) {
        Op* first = new Op(2);
        Op* second = new Op(4);
        Pow testPow(first, second);
        EXPECT_EQ(16, testPow.evaluate());
}

TEST(PowTest, Stringify) {
        Op* first = new Op(3);
        Op* second = new Op(2);
        Pow testPow(first, second);
        EXPECT_EQ("3 ** 2", testPow.stringify());
}

TEST(AbsTest, Evaluate) {
        Op* first = new Op(-2);
        Absolute hi(first);
        EXPECT_EQ(2, hi.evaluate());
}

TEST(CeilTest, Evaluate) {
        Op* first = new Op(2.55);
        Ceil hi(first);
        EXPECT_EQ(3, hi.evaluate());
}

TEST(FloorTest, Evaluate) {
        Op* first = new Op(5.3);
        Floor hi(first);
        EXPECT_EQ(5, hi.evaluate());
}



TEST(TruncTest, Stringify) {
        Op* first = new Op(6);
        Op* second = new Op(20);
        Mult* multiplication = new Mult(first, second);
        Trunc* testTrunc = new Trunc(multiplication);
        Op* third = new Op(4);
        Add addition(testTrunc, third);
        EXPECT_EQ("120 + 4", addition.stringify());
}

TEST(TruncTest2, Stringify) {
        Op* first = new Op(-6);
        Op* second = new Op(20);
        Mult* multiplication = new Mult(first, second);
        Absolute* Abs = new Absolute (multiplication);
        Trunc* testTrunc = new Trunc(Abs);
        EXPECT_EQ("120", testTrunc->stringify());
}


TEST(TruncTest3, Stringify) {
        Op* first = new Op(6);
        Op* second = new Op(20);
        Mult* multiplication = new Mult(first, second);
        Floor* floor = new Floor (multiplication);
        Absolute* Abs = new Absolute (floor);
        Trunc* testTrunc = new Trunc(Abs);
        EXPECT_EQ("120", testTrunc->stringify());
}

TEST(TruncTest4, Stringify) {
        Op* first = new Op(6);
        Op* second = new Op(20);
        Mult* multiplication = new Mult(first, second);
        Floor* floor = new Floor (multiplication);
        Absolute* Abs = new Absolute (floor);
        Ceil* ceil = new Ceil(Abs);
        Trunc* testTrunc = new Trunc(ceil);
        EXPECT_EQ("120", testTrunc->stringify());
}

TEST(TruncTest5, Stringify) {
        Op* first = new Op(6);
        Op* second = new Op(0.2);
        Mult* multiplication = new Mult(first, second);
        Floor* floor = new Floor (multiplication);
        Trunc* testTrunc = new Trunc(floor);
        EXPECT_EQ("1", testTrunc->stringify());
}

TEST(TruncTest6, Stringify) {
        Op* first = new Op(6);
        Op* second = new Op(0.2);
        Mult* multiplication = new Mult(first, second);
        Ceil* ceil = new Ceil (multiplication);
 Trunc* testTrunc = new Trunc(ceil);
        EXPECT_EQ("2", testTrunc->stringify());
}


TEST(ParenTest, Stringify) {
        Op* first = new Op(999);

        cout << first->evaluate() << endl;

        Floor* floor = new Floor (first);
        cout << floor->evaluate() << endl;
        Absolute* Abs = new Absolute (floor);
        cout << Abs->evaluate() << endl;
        Ceil* ceil = new Ceil(Abs);
        cout << ceil->evaluate() << endl;
        Paren* testParen= new Paren(ceil);
        cout << testParen->evaluate() << endl;
        EXPECT_EQ("(999)", testParen->stringify());
}

TEST(VectorContainerTest, Print) {
        ::testing::internal::CaptureStdout();
        Op* first = new Op(20);
        Op* second = new Op(11);
        Op* third = new Op(6);
        Container* cont = new VectorContainer();
        cont->add_element(first);
        cont->add_element(second);
        cont->add_element(third);
        cont->print();
        std::string stdOut = ::testing::internal::GetCapturedStdout().c_str();
        EXPECT_STREQ("20 11 6", stdOut.c_str());
}

TEST(VectorContainerTest, AddElement) {
        Op* first = new Op(5);
        Op* second = new Op(4);
        Container *cont = new VectorContainer();
        cont->add_element(first);
        cont->add_element(second);
        EXPECT_EQ(2, cont->size());
}
TEST(Sorts, BubbleSort) {
        Op* first = new Op(14);
        Op* second = new Op(4);
        Container* cont = new VectorContainer();
        cont->add_element(first);
        cont->add_element(second);
        Sort* bs = new BubbleSort();
        cont->set_sort_function(bs);
        cont->sort();
        EXPECT_EQ("14", cont->at(1)->stringify());
}

TEST(ListContainerTest, AddElement) {
        Op* first = new Op(400);
        Container *cont = new VectorContainer();
        cont->add_element(first);
        EXPECT_EQ(1, cont->size());
}
TEST(SciTest, Stringify) {
        SciOp test(3.1415);
        EXPECT_EQ("3.141500e+00", test.stringify());
}

TEST(OpTest, Stringify) {
        PrecisionOp test(3.1415);
        EXPECT_EQ("3.14", test.stringify());
}

TEST(FactoryTest, Double) {
        srand(812);
        DoubleFactory* dFact = new DoubleFactory();
        Base* currOp = dFact->createOp(12.17);
        Base* currRand = dFact->createRand();
        EXPECT_EQ(currOp->evaluate(), 12.17);
        EXPECT_EQ(currOp->stringify(), "12.17");
}

TEST(FactoryTest, precision) {
       srand(586);
        PrecisionFactory* sciFact = new PrecisionFactory();
        Base* currOp = sciFact->createOp(23.4);
        Base* currRand = sciFact->createRand();
        EXPECT_EQ(currOp->evaluate(), 23.4);
        EXPECT_EQ(currOp->stringify(), "23.4");


}

TEST(FactoryTest, scientific) {
       srand(90);
        SciFactory* sciFact = new SciFactory();
        Base* currOp = sciFact->createOp(8626.34);
        Base* currRand = sciFact->createRand();
        EXPECT_EQ(currOp->evaluate(), 8626.34);
        EXPECT_EQ(currOp->stringify(), "8.626340e+03");


}
*/
TEST(Iterator, Check) {
        Op* x = new Op(73);
        Op* y = new Op(30);
        Add* add = new Add(x, y);
        Iterator* iter = add->create_iterator();
        iter->first();

        EXPECT_EQ(103, iter->current()->evaluate());
}
/*
TEST(SecondIterator, Check) {
        Op* x = new Op(24);
        Op* y = new Op(3);
        Sub* sub = new Sub(x, y);
        Iterator* iter = sub->create_iterator();
        iter->first();
        iter->next();
        EXPECT_EQ(24, iter->current()->evaluate());
}
*/
TEST(FinalIterator, NullIteratorCheck) {
        Op* x = new Op(2);
        Iterator* iter = x->create_iterator();
        iter->first();
        EXPECT_EQ(true, iter->current() == nullptr);
}
TEST(CountVisitor, Check) {
        Op* x = new Op(73);
        Op* y = new Op(30);
        Add* add = new Add(x, y);
        Iterator* iter = add->create_iterator();
        iter->first();
        CountVisitor* count = new CountVisitor();
        iter->current()->accept(count);
        EXPECT_EQ(1, count->add_count());
}
/*
TEST(CountVisitorTwo, Check) {
        Op* x = new Op(32.78);
        Floor* floor = new Floor(x);
        Iterator* iter = floor->create_iterator();
        CountVisitor* count = new CountVisitor();
        iter->first();
        iter->current()->accept(count);
        
        EXPECT_EQ(32, iter->current()->evaluate());
}
*/
int main(int argc, char**argv) {
        ::testing::InitGoogleTest(&argc, argv);
        return RUN_ALL_TESTS();
}



