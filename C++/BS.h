#ifndef __BS_HPP__
#define __BS_HPP__

#include "container.hpp"
#include "sort.hpp"

class Container;

class BubbleSort : public Sort {
    public:
        /* Constructors */
        BubbleSort();

        /* Pure Virtual Functions from parent class */
        void sort(Container* container);
};

#endif
