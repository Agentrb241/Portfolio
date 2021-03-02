#ifndef __SS_H__
#define __SS_H__

#include "container.hpp"
#include "sort.hpp"

class Container;

class SelectionSort : public Sort {
    public:
        /* Constructors */
       SelectionSort();


        void sort(Container* container);
};

#endif
