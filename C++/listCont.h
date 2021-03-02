#ifndef ADD_H
#define ADD_H

#include "container.hpp"
#include "base.h"
#include <list>
#include <iostream>

class ListContainer : public Container {
public:
        /* Constructors */
        ListContainer();
        ListContainer(Sort* function);

        /* Non Virtual Functions */
        void set_sort_function(Sort* sort_function); //set the type of sorting algorithm

        /* Pure Virtual Functions from parent class defined here */
        void add_element(Base* element);
        void print();
        void sort();

        /* Functions Needed to Sort */
void swap(int i, int j);
        Base* at(int i);
        int size();

private:
        std::list<Base*> listCont;
};

#endif

